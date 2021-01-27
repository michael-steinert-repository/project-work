import axios from 'axios';

const api = axios.create({
    baseURL: 'http://localhost:8081/user-registration',
    headers: {
        'Content-Type': 'application/json'
    }
});

export const registerUser = async (userEntity) => {
    return await api.post( '/register', userEntity).then(response => response.data).catch((error) => {
        console.log("Error:", error);
    });
}

export const authenticateUser = async (userEntity) => {
    return await api.post( '/authenticate', userEntity).then(response => response.data).catch((error) => {
        console.log("Error:", error);
    });
}