import { useState, useEffect, useContext } from "react";
import { LoadingSpinner } from "./LoadingSpinner";
import { Context } from "../App";
import { IoClose } from "react-icons/io5";

type LoginProps = {};

export const Login: React.FC<LoginProps> = ({}) => {
	const context = useContext(Context);

	if (!context) return null;

	const { userName, setUsername } = context;
	const { signedIn, setIsSignedIn } = context;
	const [tempUsername, setTempUsername] = useState(userName);
	const [password, setPassword] = useState("");
	const [loading, setIsLoading] = useState(false);
	const { loginModalOpen, setLoginModalOpen } = context;

	useEffect(() => {
		if (loading) {
			const timer = setTimeout(() => {
				setIsLoading(false);
				setLoginModalOpen(false);
				// if (loading) alert("Profile details successfully updated!");
			}, 3000);
			return () => clearTimeout(timer);
		}
	}, [loading]);

	const handleName = (e) => {
		setTempUsername(e.target.value);
	};

	const signIn = () => {
		setLoginModalOpen(false);
		setUsername(tempUsername);
		setIsSignedIn(true);
	};

	if (!loginModalOpen) return null;

	return (
		<div className="fixed inset-0 bg-black/50 flex items-center justify-center z-50">
			<div className="bg-gray-900/20 backdrop-blur-2xl border-2 border-gray-400 rounded-2xl shadow-lg w-[500px] p-6 relative">
				{/* Close button */}
				<button
					onClick={() => setLoginModalOpen(false)}
					className="absolute top-3 right-3 text-white hover:text-gray-300 bg-red-500/0"
				>
					<IoClose size={20} />
				</button>

				{loading ? (
					<div className="flex justify-center items-center py-10">
						<LoadingSpinner />
					</div>
				) : (
					<>
						<h2 className="text-2xl font-bold text-center mb-6">LOG IN</h2>

						<aside className="flex flex-col gap-5">
							{/* Username */}
							<div className="text-left w-full">
								<label className="text-lg">User Name</label>
								<input
									type="text"
									className="bg-gray-100 rounded-md text-black text-md w-full p-2 mt-1"
									value={tempUsername}
									onChange={handleName}
								/>
							</div>

							{/* Oassword */}
							<div className="text-left w-full">
								<label className="text-lg">Password</label>
								<input
									type="password"
									className="bg-gray-100 rounded-md text-black text-md w-full p-2 mt-1"
									value={password}
									onChange={(e) => setPassword(e.target.value)}
								/>
							</div>

							{/* Save button */}
							<div className="flex justify-end">
								<button
									className="bg-blue-400 hover:bg-green-600 text-white px-4 py-2 rounded-lg"
									onClick={signIn}
								>
									Login
								</button>
							</div>
						</aside>
					</>
				)}
			</div>
		</div>
	);
};
