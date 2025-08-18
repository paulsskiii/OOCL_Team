import UpdateProfileForm from './UpdateProfileForm';

function UpdateProfile({ setProfile, profile }) {

  return (
        <div className="d-flex justify-content-center">
            <div className="contact-form p-5 text-start text-dark rounded-5 row p-2 bg-opacity-50">
                <UpdateProfileForm setProfile = { setProfile } profile = { profile }/>
            </div>
        </div>
  )
}
export default UpdateProfile;