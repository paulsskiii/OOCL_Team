function StatusColumnRecord({ status }) {
  /*('Delivered', 'DLV', NOW(), NOW()),
('In-Transit', 'ITR', NOW(), NOW()),
('Loaded', 'LOD', NOW(), NOW()),
('Discharged', 'DSC', NOW(), NOW()),
('Pending', 'PND', NOW(), NOW()),
('In-Process', 'PRC', NOW(), NOW()),
('Not-Delivered', 'NDL', NOW(), NOW()) 
*/

  const statusStyles = {
    Delivered: "text-green-700 bg-green-100 border-green-500", // Success
    "In-Transit": "text-blue-700 bg-blue-100 border-blue-500", // Info
    Loaded: "text-blue-700 bg-blue-100 border-blue-500", // Info
    Discharged: "text-purple-700 bg-purple-100 border-purple-500", // Action completed
    Pending: "text-yellow-700 bg-yellow-100 border-yellow-500", // Warning
    "In-Process": "text-orange-700 bg-orange-100 border-orange-500", // Processing
    "Not-Delivered": "text-red-700 bg-red-100 border-red-500", // Error
  };

  const style = statusStyles[status] || statusStyles.default;

  return (
    <div
      className={`flex flex-row items-center w-fit gap-1 px-2 text-sm font-normal text-center ${style} border rounded-3xl`}
    >
      {status}
    </div>
  );
}

export default StatusColumnRecord;
