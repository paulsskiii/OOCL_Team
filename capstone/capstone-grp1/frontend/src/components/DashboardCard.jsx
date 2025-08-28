import {
	Truck,
	Container as LucideContainer,
	Ship,
	PlusCircle,
	Search,
	ChevronUp,
	ChevronDown,
} from "lucide-react";

function DashboardCard({ icon, category, number, item, message, percentage }) {
	return (
		<div className="flex flex-col w-1/4 h-40 p-5 border-2 border-gray-200 rounded-lg shadow-sm lg:flex-row hover:bg-gray-100">
			<section>
				<article className="flex flex-row items-center gap-2 mb-5">
					{icon}
					<div className="text-lg font-semibold">Total {category}</div>
				</article>
				<article className="flex flex-row items-end gap-1">
					<div className="text-4xl font-semibold">{number}</div>
					<span className="text-lg font-normal text-gray-600">{item}</span>
				</article>
				<div className="mt-2 text-lg text-gray-500">{message}</div>
			</section>
			<section className="flex items-center ml-auto">
				{percentage > 0 ? (
					<div className="flex flex-row items-center gap-1 px-2 text-lg font-semibold text-center text-green-700 bg-green-300 border-2 border-green-700 rounded-3xl">
						<ChevronUp size={20} />
						<span>{percentage}%</span>
					</div>
				) : (
					<div className="flex flex-row items-center gap-1 px-2 text-lg font-semibold text-center text-red-700 bg-red-300 border-2 border-red-700 rounded-3xl">
						<ChevronDown size={20} />
						<span>{percentage}%</span>
					</div>
				)}
			</section>
		</div>
	);
}

export default DashboardCard;
