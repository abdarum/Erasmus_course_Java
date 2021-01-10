import React, {
  useContext,
  useEffect,
  useState
} from 'react';
import PageTitle from '../components/common/PageTitle';
import { FetchContext } from '../context/FetchContext';
import Card from '../components/common/Card';
import UserFullDetailsForm from '../components/UserFullDetailsForm';
import { AuthContext } from './../context/AuthContext';
import qs from 'query-string';
import { useTranslation } from "react-i18next";

const ManageBooks = () => {
  const fetchContext = useContext(FetchContext);
  const [books, setBooks] = useState([]);
  const auth = useContext(AuthContext);
  const { t } = useTranslation('common');

  useEffect(() => {
    var queryValues = {
      token: auth.authState.token
    }
    console.log(queryValues);
    const getBooks = async () => {
      try {
        const { data } = await fetchContext.authAxios.get(
          '/book?'+qs.stringify(queryValues)
        );
        console.log(data);
        setBooks(data);
      } catch (err) {
        console.log(err);
      }
    };
    getBooks();
  }, [fetchContext.authAxios]);

  return (
    <>
      <PageTitle title={t('pages.manage_books_page.title')} />
      <div className="flex flex-col">
        <Card>
          {/* <UserFullDetailsForm /> */}
        </Card>
        {!!books.length &&
          books.map(user => (
            <div className="m-2">
              <Card>
                {/* <UserFullDetailsForm key={user._id} user={user} /> */}
              </Card>
            </div>
          ))}
      </div>
    </>
  );
};

export default ManageBooks;
