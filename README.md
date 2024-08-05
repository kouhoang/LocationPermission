# Ứng Dụng Định Vị

Ứng dụng Android này yêu cầu quyền truy cập vị trí, lấy tọa độ hiện tại của thiết bị (kinh độ và vĩ độ) và hiển thị các tọa độ này. Ban đầu, ứng dụng hiển thị trạng thái quyền truy cập và cập nhật nó sau khi người dùng cấp quyền.

## Chức Năng

- Kiểm tra và yêu cầu quyền truy cập vị trí.
- Lấy tọa độ hiện tại của thiết bị.
- Hiển thị kinh độ và vĩ độ trên hai dòng riêng biệt.
- Cập nhật trạng thái quyền truy cập vị trí.

## Yêu Cầu

- Android Studio
- Thiết bị hoặc trình giả lập chạy Android 6.0 (API 23) trở lên
- Google Play Services

## Cài Đặt

1. Tải hoặc clone repository về máy của bạn:

    ```bash
    git clone https://github.com/kouhoang/LocationPermission.git
    ```

2. Mở dự án bằng Android Studio.

3. Chạy ứng dụng trên thiết bị hoặc trình giả lập của bạn.


## Hướng Dẫn Sử Dụng

1. Khi mở ứng dụng, bạn sẽ thấy thông báo "Location Permission: Not granted".
2. Nhấn nút "START" để yêu cầu quyền truy cập vị trí.
3. Nếu quyền được cấp, ứng dụng sẽ hiển thị kinh độ và vĩ độ hiện tại của thiết bị.
4. Nút "START" sẽ chuyển từ màu xanh lá sang màu xám sau khi lấy được tọa độ.
