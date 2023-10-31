const BASE_URL = 'http://localhost:8080'; // Replace with your Spring Boot backend URL

export const login = async (username, password) => {
    try {
        const response = await fetch(`${BASE_URL}/login`, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({ username, password }),
        });

        if (!response.ok) {
            throw new Error('Login failed');
        }

        const data = await response.json();
        return data; // You might receive a token or user information from the backend
    } catch (error) {
        console.error('Error during login:', error);
        throw error;
    }
};

export const fetchData = async (accessToken) => {
    try {
        const response = await fetch(`${BASE_URL}/api/data`, {
            method: 'GET',
            headers: {
                'Authorization': `Bearer ${accessToken}`, // Include this if your backend requires authentication
                'Content-Type': 'application/json',
            },
        });

        if (!response.ok) {
            throw new Error('Failed to fetch data');
        }

        const data = await response.json();
        return data;
    } catch (error) {
        console.error('Error during data fetch:', error);
        throw error;
    }
};
