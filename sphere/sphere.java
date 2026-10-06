public class sphere {
    public static void main(String[] args) throws InterruptedException {
        // Screen dimensions
        int width = 80;
        int height = 40;
        
        // Sphere properties
        double radius = 15;
        double rX = 0, rY = 0; // Rotation angles

        // Shading characters from darkest to brightest
        char[] shading = {'.', '-', '~', ':', ';', '=', '!', '*', '#', '$', '@'};

        // Infinite animation loop
        while (true) {
            char[] output = new char[width * height];
            double[] zBuffer = new double[width * height];
            
            // Clear buffers
            for (int i = 0; i < output.length; i++) {
                output[i] = ' ';
                zBuffer[i] = Double.NEGATIVE_INFINITY;
            }

            // Loop through spherical coordinates (theta and phi)
            for (double theta = 0; theta < Math.PI; theta += 0.05) {
                for (double phi = 0; phi < 2 * Math.PI; phi += 0.05) {
                    
                    // 1. Calculate 3D coordinates on the sphere surface
                    double x = radius * Math.sin(theta) * Math.cos(phi);
                    double y = radius * Math.sin(theta) * Math.sin(phi);
                    double z = radius * Math.cos(theta);

                    // 2. Rotate around X and Y axes
                    // Rotate X
                    double y1 = y * Math.cos(rX) - z * Math.sin(rX);
                    double z1 = y * Math.sin(rX) + z * Math.cos(rX);
                    
                    // Rotate Y
                    double x2 = x * Math.cos(rY) + z1 * Math.sin(rY);
                    double z2 = -x * Math.sin(rY) + z1 * Math.cos(rY);

                    // 3. Project onto 2D screen with aspect ratio correction
                    int screenX = (int) (width / 2 + x2 * 2.0); // Characters are taller than wide
                    int screenY = (int) (height / 2 + y1);

                    // Check bounds and Z-buffer for visibility
                    if (screenX >= 0 && screenX < width && screenY >= 0 && screenY < height) {
                        int idx = screenX + screenY * width;
                        
                        if (z2 > zBuffer[idx]) {
                            zBuffer[idx] = z2;

                            // 4. Basic lighting estimation (dot product with light vector)
                            // Light vector pointing from front-top-left [-1, 1, -1]
                            double nx = Math.sin(theta) * Math.cos(phi);
                            double ny = Math.sin(theta) * Math.sin(phi);
                            double nz = Math.cos(theta);
                            
                            double luminance = (nx * -1 + ny * 1 + nz * -1) / Math.sqrt(3);
                            
                            // Map luminance to shading array index
                            int shadeIdx = (int) ((luminance + 1) / 2 * (shading.length - 1));
                            shadeIdx = Math.max(0, Math.min(shading.length - 1, shadeIdx));
                            
                            output[idx] = shading[shadeIdx];
                        }
                    }
                }
            }

            // Print the frame to the console
            System.out.print("\033[H"); // Move cursor to top-left corner
            StringBuilder frame = new StringBuilder();
            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    frame.append(output[x + y * width]);
                }
                frame.append('\n');
            }
            System.out.print(frame);

            // Increment rotation angles for the next frame
            rX += 0.04;
            rY += 0.02;

            // Cap the frame rate (~30 FPS)
            Thread.sleep(1);
        }
    }
}
