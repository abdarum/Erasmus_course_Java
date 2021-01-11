import React, {
  useContext,
  useEffect,
  useState
} from 'react';
import PageTitle from '../components/common/PageTitle';
import { FetchContext } from '../context/FetchContext';
import Card from '../components/common/Card';
import BookFullDetailsForm from '../components/BookFullDetailsForm';
import { AuthContext } from './../context/AuthContext';
import qs from 'query-string';
import { useTranslation } from "react-i18next";

const ManageOrders = () => {
  const fetchContext = useContext(FetchContext);
  const [books, setBooks] = useState([]);
  const auth = useContext(AuthContext);
  const { t } = useTranslation('common');

  useEffect(() => {
    var queryValues = {
      token: auth.authState.token
    }
  }, [fetchContext.authAxios]);

  return (
    <>
      <PageTitle title={t('pages.manage_orders_page.title')} />
      <div className="flex flex-col">
        <Card>
          {/* <BookFullDetailsForm
            authorsRawList={authorsRaw}
            coverTypesRawList={coverTypesRaw}
            bookGenresRawList={bookGenresRaw}
            borrowPeriodsRawList={borrowPeriodsRaw}
            borrowPlaceRawList={borrowPlaceRaw}
          /> */}
        </Card>
        {!!books.length &&
          books.map(book => (
            <div className="m-2">
              <Card>
                {/* <BookFullDetailsForm key={book._id} book={book}
                  authorsRawList={authorsRaw}
                  coverTypesRawList={coverTypesRaw}
                  bookGenresRawList={bookGenresRaw}
                  borrowPeriodsRawList={borrowPeriodsRaw}
                  borrowPlaceRawList={borrowPlaceRaw}
                /> */}
              </Card>
            </div>
          ))}
      </div>
    </>
  );
};

export default ManageOrders;
