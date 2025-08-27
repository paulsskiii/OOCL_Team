import { useState, useEffect } from "react";

function DeleteModal({
  deleteModal,
  setDeleteModal,
  selectedContainer,
  setSelectedContainer,
  handleDelete,
}) {
  function deleteContainerClick() {
    handleDelete(selectedContainer);
    setDeleteModal(false);
    setSelectedContainer(null);
  }

  function cancelContainerClick() {
    setSelectedContainer(null);
    setDeleteModal(false);
  }

  if (!deleteModal) return null;
  return (
    <div className="fixed inset-0 bg-black/50 flex items-center justify-center z-50">
      <div className="bg-white backdrop-blur-2xl border-2 border-gray-400 rounded-2xl shadow-lg w-[500px] p-6 relative items-center justify-center flex flex-col gap-5">
        <div className="font-bold text-red-500 text-xl">DELETE CONTAINER</div>
        <div>
          Are you sure want to delete{" "}
          <span className="font-semibold text-lg">
            {selectedContainer.containerName}
          </span>
          ?
        </div>
        <div className="flex flex-row gap-3">
          <button
            className="bg-gray-400 text-white font-semibold border border-5 rounded-lg p-3"
            onClick={() => {
              cancelContainerClick();
            }}
          >
            Cancel
          </button>
          <button
            className="bg-red-500 text-white font-semibold border border-5 rounded-lg p-3"
            onClick={() => {
              deleteContainerClick();
              setDeleteModal(false);
            }}
          >
            Delete
          </button>
        </div>
      </div>
    </div>
  );
}

export default DeleteModal;
