import {useState} from "react";
import Modal from "antd/es/modal/Modal";

type CustomerProps = {
    customerId: number;
    firstName: string;
    lastName: string;
    contactNumber: string;
    emailAddress: string;
    addressLine1: string;
    addressLine2: string;
    locationId: number;
} | null;

function CustomerModal ({openModal, customer} : {openModal: boolean, customer: CustomerProps} ) {
    const [open, setOpen] = useState(openModal);

    const handleOk = () => {
        setOpen(false);
    };
    const handleCancel = () => {
        setOpen(false);
    };

    return (
        <Modal
            title="Basic Modal"
            closable={{ 'aria-label': 'Custom Close Button' }}
            open={open}
            onOk={handleOk}
            onCancel={handleCancel}
        >
            <p>{customer?.customerId}</p>
            <p>{customer?.firstName}</p>
        </Modal>
    )
}

export default CustomerModal;