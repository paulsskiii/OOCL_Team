import {
  LinkOutlined
} from "@ant-design/icons";
import { Avatar, Card } from "antd";
import Meta from "antd/es/card/Meta";

type CustomCardProps = {
  title: string,
  desc: string
}

export const CustomCard: React.FC<CustomCardProps> = ({title, desc}) => {
  return (
    <Card
      style={{ width: 500 }}
      cover={<img alt="example" src="src\assets\display_pic.jpg" />}
      actions={[
        <a href="https://www.atlantis-press.com/proceedings/wctp-23/125998949"><LinkOutlined key="link" /></a>
      ]}
    >
      <Meta
        avatar={
          <Avatar src="https://api.dicebear.com/7.x/miniavs/svg?seed=8" />
        }
        title={title}
        description={desc}
      />
    </Card>
  );
};
