package pers.god.demo.file;

/**
 * @Author chuhao
 * @Date 2025/2/8
 * @Version 1.0.0
 */
public class Demo1 {

    private static final String[] UNITS = {"B", "KB", "MB", "GB", "TB"};

    public static String convertBytes(long bytes) {
        if (bytes < 0) {
            throw new IllegalArgumentException("字节数不能为负数");
        }
        if (bytes == 0) {
            return "0 B";
        }

        int unitIndex = 0;
        double size = bytes;

        // 循环除以1024直到找到合适的单位
        while (size >= 1024 && unitIndex < UNITS.length - 1) {
            size /= 1024;
            unitIndex++;
        }

        // 根据是否为整数选择不同的格式
        return size == (long) size
                ? String.format("%d %s", (long) size, UNITS[unitIndex])
                : String.format("%.1f %s", size, UNITS[unitIndex]);
    }

    public static void main(String[] args) {
        // 测试用例
        System.out.println(convertBytes(500));        // 500 B
        System.out.println(convertBytes(1024));       // 1 KB
        System.out.println(convertBytes(1536));       // 1.5 KB
        System.out.println(convertBytes(1_048_576));  // 1.0 MB
        System.out.println(convertBytes(1073741824L)); // 1 GB
        System.out.println(convertBytes(2_199_023_255_552L)); // 2 TB
        System.out.println(convertBytes(18357)); // 2 TB
        System.out.println(convertBytes(1024000)); // 2 TB
    }
}
