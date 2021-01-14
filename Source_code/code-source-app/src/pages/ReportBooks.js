import React, {
  useContext,
  useEffect,
  useState
} from 'react';
import PageTitle from '../components/common/PageTitle';
import { FetchContext } from '../context/FetchContext';
import Card from '../components/common/Card';
import BookItemOverviewShort from '../components/BookItemOverviewShort';
import { useTranslation } from "react-i18next";
import { AuthContext } from '../context/AuthContext';
import qs from 'query-string';

const ReportBooks = () => {
  const auth = useContext(AuthContext);
  const fetchContext = useContext(FetchContext);
  const [booksInfo, setBooksInfo] = useState();
  const { t } = useTranslation('common');

  useEffect(() => {
    var queryValues = {
      token: auth.authState.token
    }
    
    const getBooksInfo = async () => {
      try {
        const { data } = await fetchContext.authAxios.get(
          'library/inventory/books?' + qs.stringify(queryValues)
        );
        setBooksInfo(data);
        
      } catch (err) {
        console.log(err);
      }
    };
    getBooksInfo();
  }, [fetchContext.authAxios]);


  return (
    <>
      <PageTitle title={t('pages.report_books_page.title')} />
      {booksInfo ? (
        <>
          <Card>
            <div className="flex text-3xl justify-around">
              <p className="text-yellow-600">{t('pages.report_books_page.books_numbers_summary_component.number_of_books') + booksInfo.numberOfBooks}</p>
              <p className="text-green-600">{t('pages.report_books_page.books_numbers_summary_component.number_of_available_books') + booksInfo.numberOfAvailableBooks}</p>
            </div>
          </Card>
          <br />
        </>
      ) : <div />}
      {booksInfo && booksInfo.books && !!booksInfo.books.length &&
        booksInfo.books.map(book => (
          <div className="m-2">
            <Card>
              {book.id}
              <BookItemOverviewShort key={book.id} bookItem={book} />
            </Card>
          </div>
        ))}
    </>
  );
};

export default ReportBooks;
