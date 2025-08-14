import { CgProfile } from "react-icons/cg";
import { FaPhoneAlt } from "react-icons/fa";
import { MdEmail } from "react-icons/md";
import { FaLocationDot } from "react-icons/fa6";

function DataCard({ fullName, contactNumber, emailAddress, location }) {
	return (
		<section className="flex flex-col h-64 w-64 bg-white rounded-lg items-center justify-center mx-auto border-2 border-gray-300">
			<article className="h-1/2 flex flex-col items-center justify-center bg-red-200 w-full rounded-t-md">
				<CgProfile size={30} />
				<div className="text-xl font-bold text-center">{fullName}</div>
			</article>

			<article className="h-1/2  grid grid-cols-[auto_1fr] gap-5 items-center justify-center px-auto m-5 text-sm">
				<FaPhoneAlt size={25} />
				<div>{contactNumber}</div>

				<MdEmail size={25} />
				<div>{emailAddress}</div>

				<FaLocationDot size={25} />
				<div>{location}</div>
			</article>
		</section>
	);
}

export default DataCard;
