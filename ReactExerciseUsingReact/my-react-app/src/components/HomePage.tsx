import { HeaderProps } from "./Header";
import { BioSection } from "./BioSection";
import { SkillsList } from "./SkillsList";

function HomePage(){
    return(
        <div>
            <HeaderProps name = "Cyrus Katigbac" position = "Programmer" />
            <BioSection />
            <SkillsList />
            
        </div>
    )
}

export default HomePage;
