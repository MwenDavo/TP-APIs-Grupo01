import React from 'react';
import { Route, Navigate } from 'react-router-dom';

function PrivateRoute({ element, loggedIn }) {
    return loggedIn ? <Route element={element} /> : <Navigate to="/login" />;
}

export default PrivateRoute;