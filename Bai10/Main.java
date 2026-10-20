package Bai10;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;



public class Main {

    // doc file theo tung dong, luu vao map
    static Map<String, String> docConfig(String duongDan)
            throws IOException, InvalidConfigException {

        Map<String, String> config = new LinkedHashMap<>();
        BufferedReader br = null;

        try {
            br = new BufferedReader(new FileReader(duongDan));
            String line;
            int soDong = 0;

            while ((line = br.readLine()) != null) {
                soDong++;
                line = line.trim();

                // bo qua dong trong va dong chu thich
                if (line.isEmpty() || line.startsWith("#")) {
                    continue;
                }

                // tach theo dau = (toi da 2 phan, de value co the chua dau =)
                String[] parts = line.split("=", 2);
                if (parts.length != 2 || parts[0].trim().isEmpty()) {
                    throw new InvalidConfigException(
                            "Line " + soDong + " is not in key=value format");
                }

                config.put(parts[0].trim(), parts[1].trim());
            }
        } finally {
            // dong file trong finally
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    System.out.println("Cannot close file: " + e.getMessage());
                }
            }
        }
        return config;
    }

    // kiem tra tinh hop le cua cac tham so
    static void kiemTra(Map<String, String> config) throws InvalidConfigException {
        // username bat buoc co
        String username = config.get("username");
        if (username == null || username.isEmpty()) {
            throw new InvalidConfigException("Missing required key: username");
        }

        // timeout bat buoc co, la so nguyen > 0
        String timeoutStr = config.get("timeout");
        if (timeoutStr == null || timeoutStr.isEmpty()) {
            throw new InvalidConfigException("Missing required key: timeout");
        }
        int timeout = Integer.parseInt(timeoutStr); // sai dinh dang -> NumberFormatException
        if (timeout <= 0) {
            throw new InvalidConfigException("timeout must be > 0");
        }

        // maxConnections la tuy chon, neu co thi phai la so nguyen >= 1
        String maxStr = config.get("maxConnections");
        if (maxStr != null) {
            int max = Integer.parseInt(maxStr);
            if (max < 1) {
                throw new InvalidConfigException("maxConnections must be >= 1");
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Nhap duong dan file config: ");
            String duongDan = sc.nextLine().trim();

            Map<String, String> config = docConfig(duongDan);
            kiemTra(config);

            // hop le: in toan bo cau hinh
            for (Map.Entry<String, String> e : config.entrySet()) {
                System.out.println(e.getKey() + "=" + e.getValue());
            }
            System.out.println("Config loaded successfully.");

        } catch (FileNotFoundException e) {
            System.out.println("Config file not found.");
        } catch (IOException e) {
            System.out.println("I/O error.");
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.out.println("Invalid number format.");
        } catch (InvalidConfigException e) {
            System.out.println("Invalid config: " + e.getMessage());
        } finally {
            // luon in, du co loi hay khong
            System.out.println("Program finished.");
            sc.close();
        }
    }
}
