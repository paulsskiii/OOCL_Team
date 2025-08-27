import { useState, useEffect, useContext } from "react";
import { LoadingSpinner } from "./LoadingSpinner";
import { Context } from "../App";
import { IoClose } from "react-icons/io5";

type UserProfileProps = {};

export const UserProfile: React.FC<UserProfileProps> = ({}) => {
	const context = useContext(Context);

	if (!context) return null;

	const { name, setName } = context;
	const { email, setEmail } = context;
	const { description, setDescription } = context;
	const { hobbies, setHobbies } = context;
	const { profileModalOpen, setProfileModalOpen } = context;

	const [tempName, setTempName] = useState(name);
	const [loading, setIsLoading] = useState(false);
	const [tempEmail, setTempEmail] = useState(email);
	const [tempDesc, setTempDesc] = useState(description);
	const [tempHobbies, setTempHobbies] = useState(hobbies);

	useEffect(() => {
		if (loading) {
			const timer = setTimeout(() => {
				setIsLoading(false);
				setProfileModalOpen(false);
				if (loading) alert("Profile details successfully updated!");
			}, 3000);
			return () => clearTimeout(timer);
		}
	}, [loading]);

	const handleName = (e) => {
		setTempName(e.target.value);
	};

	const handleEmail = (e) => {
		setTempEmail(e.target.value);
	};

	const handleDescription = (e) => {
		setTempDesc(e.target.value);
	};

	const handleHobbies = (e) => {
		setTempHobbies(e.target.value);
	};

	function editProfile() {
		setEmail(tempEmail);
		setName(tempName);
		setDescription(tempDesc);
		setHobbies(tempHobbies);
		setIsLoading(true);
	}

	if (!profileModalOpen) return null;

	return (
		<div className="fixed inset-0 bg-black/50 flex items-center justify-center z-50">
			<div className="bg-gray-900/20 backdrop-blur-2xl border-2 border-gray-400 rounded-2xl shadow-lg w-[500px] p-6 relative">
				{/* Close button */}
				<button
					onClick={() => setProfileModalOpen(false)}
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
						<h2 className="text-2xl font-bold text-center mb-6">
							Edit Profile
						</h2>

						<aside className="flex flex-col gap-5">
							{/* Username */}
							<div className="text-left w-full">
								<label className="text-lg">User Name</label>
								<input
									type="text"
									className="bg-gray-100 rounded-md text-black text-md w-full p-2 mt-1"
									value={tempName}
									onChange={handleName}
								/>
							</div>

							{/* Email */}
							<div className="text-left w-full">
								<label className="text-lg">Email</label>
								<input
									type="text"
									className="bg-gray-100 rounded-md text-black text-md w-full p-2 mt-1"
									value={tempEmail}
									onChange={handleEmail}
								/>
							</div>

							{/* Description */}
							<div className="text-left w-full">
								<label className="text-lg">Description</label>
								<textarea
									className="bg-gray-100 rounded-md text-black text-md p-2 w-full h-32 mt-1"
									value={tempDesc}
									onChange={handleDescription}
								/>
							</div>

							{/* Hobbies */}
							<div className="text-left w-full">
								<label className="text-lg">Hobbies</label>
								<textarea
									className="bg-gray-100 rounded-md text-black text-md p-2 w-full h-32 mt-1"
									value={tempHobbies}
									onChange={handleHobbies}
								/>
							</div>

							{/* Save button */}
							<div className="flex justify-end">
								<button
									className="bg-blue-400 hover:bg-green-600 text-white px-4 py-2 rounded-lg"
									onClick={editProfile}
								>
									Save Changes
								</button>
							</div>
						</aside>
					</>
				)}
			</div>
		</div>
	);
};
