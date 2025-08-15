import { AiOutlineLoading3Quarters } from 'react-icons/ai';
 
function LoadingSpinner({  }) {
    return (
    <div className="fixed inset-0 z-50 flex items-center justify-center bg-black/50">
        <AiOutlineLoading3Quarters className="animate-spin" size={50}/>
        <span className="m-3 font-bold text-xl">Updating Profile...</span>
    </div>
    );
}
 
export default LoadingSpinner;