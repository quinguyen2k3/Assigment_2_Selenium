# Tự động kiểm thử Selenium cho OpenCart

Chào Ms. Hannah!

## Tổng quan

File README này giải thích cách thiết lập môi trường và chạy các script để kiểm thử OpenCart bằng Selenium WebDriver.

## 1. Yêu cầu hệ thống

- **Java Development Kit (JDK)**: Dự án sử dụng JDK 21. Tải xuống [tại đây](https://www.oracle.com/java/technologies/javase/jdk21-archive-downloads.html).
- **Maven**: Tải Apache Maven để quản lý dependencies và tạo dự án. [Tải Maven tại đây](https://maven.apache.org/download.cgi).
- **IDE**: Sử dụng Eclipse làm môi trường phát triển tích hợp (IDE). [Tải Eclipse tại đây](https://www.eclipse.org/downloads/).
- **Selenium WebDriver**: Cài đặt và cấu hình Selenium WebDriver, phiên bản [4.25.0].
- **Trình duyệt**: Dự án sử dụng Microsoft Edge để kiểm thử; đảm bảo bạn đã cài đặt phiên bản đúng của Edge WebDriver.
- **Hệ thống kiểm soát phiên bản**: Sử dụng GitHub làm hệ thống kiểm soát phiên bản.
- **JUnit**: Dự án sử dụng phiên bản [4.13.2].
- **Các công cụ khác**: Chạy file POM để tự động tải về các phụ thuộc cần thiết.
- **Web Test OpenCart**: Dự án chạy web ở mức Local. Hướng dẫn cài đặt chi tiết sẽ được trình bày trong video sau: [Video hướng dẫn](https://www.youtube.com/watch?v=GftTTFm58d8).

## 2. Các bước để chạy mã

### 2.1. Thiết lập dự án
1. **Clone dự án**:
   ```bash
   git clone https://github.com/quinguyen2k3/Assigment_2_Selenium.git
   cd Assigment_2_Selenium

2. **Chạy file POM**:
   Tải các Dependency
   ```bash
      mvn clean install
   ```
   **Lưu ý:** Trong file POM có phần sau:
   ```bash
   <configuration>  
      <skipTests>true</skipTests>  
   </configuration>
   ```
   
  Hãy xóa dòng này đi để chạy chạy các Test Case
3. **Tải các OpenCart**
4. **Chạy các Test Case**
   - Để chạy tất cả các Test Case, sử dụng lệnh:
     ```bash
     mvn test
   - Để xóa tất cả file báo cáo cũ và kết quả cũ và tạo kết quả mới hãy chạy:
     ```bash
     mvn clean test
   - Để chạy Test case đơn lẻ sử dụng lệnh:
     ```bash
     mvn -Dtest=TestClassName#testMethodName test

5. **Tạo báo cáo kiểm thử**:
    - Hãy thêm lại phần bỏ đi về chổ cũ:
       ```bash
        <configuration>  
           <skipTests>true</skipTests>  
        </configuration>
   - Sau đó thực thi lệnh để tạo file báo cáo:
        ```bash
        mvn test
   - File báo cáo dạng HTML sẽ được tạo trong thư mục target/site. Tôi đã có để những file kết quả kiểm thử của mình trong folder target/site của dự án
  
   
