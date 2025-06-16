import java.io.*;
import java.net.*;
import java.util.regex.*;

public class DouyinVideoDownloader {

    public static void main(String[] args) {
        String shareUrl = "https://v.douyin.com/iDFXjpAu/"; // 抖音分享链接

        try {
            // 1. 获取重定向后的 URL
            String redirectUrl = getRedirectedUrl(shareUrl);
            System.out.println("重定向后的 URL: " + redirectUrl);

            // 2. 提取视频页面 HTML 内容
            String htmlContent = getHtmlContent(redirectUrl);

            // 3. 从 HTML 内容中提取无水印视频 URL
            String videoUrl = extractVideoUrl(htmlContent);
            if (videoUrl != null) {
                System.out.println("提取到的视频 URL: " + videoUrl);

                // 4. 下载视频到本地
                downloadVideo(videoUrl, "douyin_video.mp4");
                System.out.println("视频已下载完成！");
            } else {
                System.out.println("未能提取到视频 URL。");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 方法1：获取重定向后的 URL
    public static String getRedirectedUrl(String url) throws IOException {
        HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
        connection.setInstanceFollowRedirects(false);
        connection.setRequestMethod("GET");
        connection.connect();
        return connection.getHeaderField("Location");
    }

    // 方法2：获取 HTML 内容
    public static String getHtmlContent(String url) throws IOException {
        StringBuilder content = new StringBuilder();
        HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("User-Agent", "Mozilla/5.0");
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line);
            }
        }
        return content.toString();
    }

    // 方法3：从 HTML 内容中提取无水印视频 URL
    public static String extractVideoUrl(String htmlContent) {
        String videoUrlRegex = "playAddr: \"(https:[^\"]+?)\"";
        Pattern pattern = Pattern.compile(videoUrlRegex);
        Matcher matcher = pattern.matcher(htmlContent);
        if (matcher.find()) {
            return matcher.group(1).replace("\\u0026", "&"); // 替换转义字符
        }
        return null;
    }

    // 方法4：下载视频到本地
    public static void downloadVideo(String videoUrl, String outputFileName) throws IOException {
        URL url = new URL(videoUrl);
        try (InputStream in = url.openStream();
             FileOutputStream out = new FileOutputStream(outputFileName)) {
            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = in.read(buffer)) != -1) {
                out.write(buffer, 0, bytesRead);
            }
        }
    }
}
