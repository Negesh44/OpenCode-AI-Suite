import { Routes, Route } from "react-router-dom";

import LoginPage from "../pages/auth/LoginPage";
import RegisterPage from "../pages/auth/RegisterPage";
import DashboardPage from "../pages/dashboard/DashboardPage";

export default function AppRoutes() {

    return (
        <Routes>

            <Route path="/" element={<LoginPage />} />

            <Route path="/login" element={<LoginPage />} />

            <Route path="/register" element={<RegisterPage />} />

            <Route path="/dashboard" element={<DashboardPage />} />

        </Routes>
    );

}