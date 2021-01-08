import React, {
  useContext,
  useEffect,
  useState
} from 'react';
import PageTitle from '../components/common/PageTitle';
import { FetchContext } from '../context/FetchContext';
import Card from '../components/common/Card';
import defaultAvatar from './../images/defaultAvatar.png';
import UserFullDetailsForm from '../components/UserFullDetailsForm';
import { AuthContext } from './../context/AuthContext';
import qs from 'query-string';
import { useTranslation } from "react-i18next";

const Users = () => {
  const fetchContext = useContext(FetchContext);
  const [users, setUsers] = useState([]);
  const auth = useContext(AuthContext);
  const { t } = useTranslation('common');

  useEffect(() => {
    var queryValues = {
      token: auth.authState.token,
      userTypeId: undefined
    }
    console.log(queryValues);
    const getUsers = async () => {
      try {
        const { data } = await fetchContext.authAxios.get(
          'user?' + qs.stringify(queryValues)
        );
        console.log(data);
        setUsers(data);
      } catch (err) {
        console.log(err);
      }
    };
    getUsers();
  }, [fetchContext.authAxios]);

  return (
    <>
      <PageTitle title={t('pages.users_page.title')} />
      <div className="flex flex-col">
        <Card>
          <UserFullDetailsForm />
        </Card>
        {!!users.length &&
          users.map(user => (
            <div className="m-2">
              <Card>
                <UserFullDetailsForm key={user._id} user={user} />
              </Card>
            </div>
          ))}
      </div>
    </>
  );
};

export default Users;
