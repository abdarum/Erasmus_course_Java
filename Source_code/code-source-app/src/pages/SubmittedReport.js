import React, {
  useContext,
  useEffect,
  useState
} from 'react';
import PageTitle from '../components/common/PageTitle';
import { FetchContext } from '../context/FetchContext';
import Card from '../components/common/Card';
import UserFullDetailsForm from '../components/UserFullDetailsForm';
import { useTranslation } from "react-i18next";
import { AuthContext } from '../context/AuthContext';
import qs from 'query-string';


const SubmittedReport = () => {
  const auth = useContext(AuthContext);
  const fetchContext = useContext(FetchContext);
  const [users, setUsers] = useState([]);
  const { t } = useTranslation('common');

  useEffect(() => {
    var queryValues = {
      token: auth.authState.token
    }
    console.log(queryValues);
    const getUsers = async () => {
      try {
        const { data } = await fetchContext.authAxios.get(
          'library/inventory/submitted?' + qs.stringify(queryValues)
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
      <PageTitle title={t('pages.submitted_report_page.title')} />
      {!!users.length &&
        users.map(user => (
          <div className="m-2">
            <Card>
              <UserFullDetailsForm key={user._id} user={user} />
            </Card>
          </div>
        ))}
    </>
  );
};

export default SubmittedReport;
