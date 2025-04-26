# Sử dụng Nginx latest làm base image
FROM nginx:latest

# Sao chép file index.html vào thư mục mặc định của Nginx
COPY index.html /usr/share/nginx/html/index.html

# Expose cổng 80
EXPOSE 80

# Chạy Nginx
CMD ["nginx", "-g", "daemon off;"]
