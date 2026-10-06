import java.io.IOException;

public class VsCodeSmoothSphere {
    public static void main(String[] args) throws InterruptedException, IOException {
        int width = 50;
        int height = 23; // Slightly shorter to fit standard VS Code panels
        
        double radius = 9;
        double rX = 0, rY = 0;

        char[] shading = {'.', '-', '~', ':', ';', '=', '!', '*', '#', '$', '@'};

        // Determine the OS clear command once
        String os = System.getProperty("os.name").toLowerCase();
        ProcessBuilder pb = os.contains("win") 
            ? new ProcessBuilder("cmd", "/c", "cls") 
            : new ProcessBuilder("clear");
        
        // Hide terminal cursor
        System.out.print("\033[?25l");

        while (true) {
            char[][] grid = new char[height][width];
            double[][] zBuffer = new double[height][width];
            
            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    grid[y][x] = ' ';
                    zBuffer[y][x] = Double.NEGATIVE_INFINITY;
                }
            }

            // Math loop
            for (double theta = 0; theta < Math.PI; theta += 0.08) {
                for (double phi = 0; phi < 2 * Math.PI; phi += 0.08) {
                    
                    double x = radius * Math.sin(theta) * Math.cos(phi);
                    double y = radius * Math.sin(theta) * Math.sin(phi);
                    double z = radius * Math.cos(theta);

                    double y1 = y * Math.cos(rX) - z * Math.sin(rX);
                    double z1 = y * Math.sin(rX) + z * Math.cos(rX);
                    
                    double x2 = x * Math.cos(rY) + z1 * Math.sin(rY);
                    double z2 = -x * Math.sin(rY) + z1 * Math.cos(rY);

                    int screenX = (int) (width / 2 + x2 * 2.2);
                    int screenY = (int) (height / 2 + y1);

                    if (screenX >= 0 && screenX < width && screenY >= 0 && screenY < height) {
                        if (z2 > zBuffer[screenY][screenX]) {
                            zBuffer[screenY][screenX] = z2;

                            double nx = Math.sin(theta) * Math.cos(phi);
                            double ny = Math.sin(theta) * Math.sin(phi);
                            double nz = Math.cos(theta);
                            
                            double luminance = (nx * -1 + ny * 1 + nz * -1) / Math.sqrt(3);
                            
                            int shadeIdx = (int) ((luminance + 1) / 2 * (shading.length - 1));
                            shadeIdx = Math.max(0, Math.min(shading.length - 1, shadeIdx));
                            
                            grid[screenY][screenX] = shading[shadeIdx];
                        }
                    }
                }
            }

            // Build the string
            StringBuilder frame = new StringBuilder();
            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    frame.append(grid[y][x]);
                }
                frame.append('\n');
            }

            // FORCE VS CODE TO FLUSH ITS WRITER SYSTEM BY INVOLVING THE SYSTEM PROCESS
            pb.inheritIO().start().waitFor(); 
            
            // Immediately print the text block right after the clear command finishes
            System.out.print(frame.toString());
            System.out.flush();

            rX += 0.05;
            rY += 0.03;

            // 40ms (~25 FPS) matches the render latency of VS Code's text terminal perfectly
            Thread.sleep(40);
        }
    }
}
