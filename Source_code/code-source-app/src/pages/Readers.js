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
import { AuthContext } from '../context/AuthContext';
import qs from 'query-string';
import { useTranslation } from "react-i18next";

const Readers = () => {
  const fetchContext = useContext(FetchContext);
  const [readers, setReaders] = useState([]);
  const auth = useContext(AuthContext);
  const { t } = useTranslation('common');

  useEffect(() => {
    var queryValues = {
      token: auth.authState.token,
      userTypeId: 3
    }
    console.log(queryValues);
    const getReaders = async () => {
      try {
        const { data } = await fetchContext.authAxios.get(
          'user?' + qs.stringify(queryValues)
        );
        console.log(data);
        setReaders(data);
      } catch (err) {
        console.log(err);
      }
    };
    getReaders();
  }, [fetchContext.authAxios]);

  return (
    <>
      <PageTitle title={t('pages.readers_page.title')} />
      <div className="flex flex-col">
        <Card>
          <UserFullDetailsForm userTypeId={3} />
        </Card>
        {!!readers.length &&
          readers.map(user => (
            <div className="m-2">
              <Card>
                <UserFullDetailsForm key={user._id} user={user} userTypeId={3} />
              </Card>
            </div>
          ))}
      </div>
    </>
  );
};

export default Readers;
