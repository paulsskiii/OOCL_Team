import { AiFillLinkedin, AiFillMail } from "react-icons/ai";
import { IoLogoFacebook } from "react-icons/io";
import { Context } from "../App";
import { useContext } from "react";

type HeaderProps = {};

export const Header: React.FC<HeaderProps> = () => {
	const context = useContext(Context);
	if (!context) return null;
	const { profileModalOpen, setProfileModalOpen } = context;
	const { signedIn, setIsSignedIn } = context;
	const { userName, setUsername } = context;
	const { loginModalOpen, setLoginModalOpen } = context;
	return (
		<div className="w-screen h p-9 mb-12 z-10 flex justify-between bg-zinc-900/95 bg-opacity-95 overflow-hidden">
			<header className="text-2xl font-poppins text-white pl-5 md:pl-20">
				MartinJ Portfolio | Welcome
				<span
					className="text-amber-200 font-semibold italic
                "
				>
					{" "}
					{userName}!{" "}
				</span>
			</header>

			<span className="pr-5 md:pr-20">
				<a href="https://www.facebook.com/MartinJ2015321/" target="_blank">
					<IoLogoFacebook
						className="inline scale-75  md:mx-1 md:scale-100"
						color="white"
						size="2rem"
					/>
				</a>
				<a href="https://www.linkedin.com/in/martinj-arellano" target="_blank">
					<AiFillLinkedin
						className="inline mx-1 scale-75  md:mx-1 md:scale-100"
						color="white"
						size="2rem"
					/>
				</a>
				<a href="mailto:martinjamesarellano@gmail.com">
					<AiFillMail
						className="inline scale-75 md:mx-1 md:scale-100"
						color="white"
						size="2rem"
					/>
				</a>
				{signedIn ? (
					<>
						|
						<span
							className="text-xl hover:font-semibold hover:cursor-pointer"
							onClick={() => setProfileModalOpen(!profileModalOpen)}
						>
							{"   "}User Profile{"   "}
						</span>
						|
						<span
							className="text-xl hover:font-semibold hover:cursor-pointer"
							onClick={() => {
								setIsSignedIn(false), setUsername("Guest");
							}}
						>
							{"   "}Logout{"   "}
						</span>
					</>
				) : (
					<span
						className="text-xl hover:font-semibold hover:cursor-pointer"
						onClick={() => setLoginModalOpen(!loginModalOpen)}
					>
						{"   "}| Login{"   "}
					</span>
				)}
			</span>
		</div>
	);
};
