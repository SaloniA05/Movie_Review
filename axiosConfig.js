import axios from "axios";

const api = axios.create({
    baseURL: 'http://localhost:8080',  // Update the baseURL to your Spring Boot server address
    headers: {
        "ngrok-skip-browser-warning": "true",
        "Access-Control-Allow-Origin": "http://localhost:3000",
        "Content-Type": "application/json",
    },
    withCredentials: true,
});

export default api;
