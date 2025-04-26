# Sử dụng node:18-alpine làm base image cho build
FROM node:18-alpine AS build

# Thiết lập thư mục làm việc
WORKDIR /app

# Sao chép file package.json và package-lock.json vào container
COPY package*.json ./

# Cài đặt dependencies
RUN npm install

# Sao chép toàn bộ source code vào container
COPY . .

# Build ứng dụng Vite
RUN npm run build

# Sử dụng Nginx để chạy ứng dụng Vite
FROM nginx:alpine

# Sao chép build output từ bước trước vào thư mục public của Nginx
COPY --from=build /app/dist /usr/share/nginx/html

# Expose cổng 80
EXPOSE 80

# Chạy Nginx
CMD ["nginx", "-g", "daemon off;"]
