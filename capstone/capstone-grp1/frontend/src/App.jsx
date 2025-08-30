// --- Frontend: src/App.js ---
import {
	BrowserRouter as Router,
	Routes,
	Route,
	Link,
	BrowserRouter,
} from "react-router-dom";
import LoginPage from "./pages/LoginPage";
import RegistrationPage from "./pages/RegistrationPage";
import MainAppPage from "./pages/MainAppPage";
const API_URL = "http://localhost:8080/api/containers";

const App = () => {
	return (
		<BrowserRouter>
			<Routes>
				<Route path="/login" element={<LoginPage />} />
				<Route path="/register" element={<RegistrationPage />} />
				<Route path="/" element={<MainAppPage />} />
			</Routes>
		</BrowserRouter>
	);
};

export default App;
