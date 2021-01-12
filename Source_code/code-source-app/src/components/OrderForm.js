import React, { useContext, useEffect, useState, useRef } from 'react';
import * as Yup from 'yup';
import { Formik, Form, Field } from 'formik';
import FormSuccess from './FormSuccess';
import FormError from './FormError';
import Label from './common/Label';
import { useHistory } from 'react-router-dom';
import { useTranslation } from "react-i18next";
import FormInput from './FormInput';
import GradientButton from './common/GradientButton';
import DangerButton from './../components/common/DangerButton';
import { FetchContext } from '../context/FetchContext';
import { AuthContext } from '../context/AuthContext';
import Select from 'react-select';
import { getTeachingLanguagesSelectOptions, getTeachingLanguagesDatabaseValues } from './TeachingLanguagesSelect';
import { getEducationLevelSelectOptions, getEducationLevelDatabaseValues } from './EducationLevelSelect';
import { getFieldOfStudySelectOptions, getFieldOfStudyDatabaseValues } from './FieldOfStudySelect';
import BookItemOverviewShort from '../components/BookItemOverviewShort';
import UserOverviewShort from '../components/UserOverviewShort';
import qs from 'query-string';
import Card from './common/Card';

const OrderForm = ({ orderItem, disabled, librarianMode }) => {
  const history = useHistory();
  const authContext = useContext(AuthContext);
  const fetchContext = useContext(FetchContext);
  const [saveSuccessLessonItemForm, setSaveSuccessLessonItemForm] = useState();
  const [saveErrorLessonItemForm, setSaveErrorLessonItemForm] = useState();
  const { t } = useTranslation('common');
  const [saveLoadingLessonItemForm, setSaveLoadingLessonItemForm] = useState(false);
  const [order, setOrder] = useState();
  const [user, setUser] = useState();
  const [book, setBook] = useState();
  const [authorsRaw, setAuthorsRaw] = useState([]);
  const [coverTypesRaw, setCoverTypesRaw] = useState([]);
  const [bookGenresRaw, setBookGenresRaw] = useState([]);
  const [borrowPeriodsRaw, setBorrowPeriodsRaw] = useState([]);
  const [borrowPlaceRaw, setBorrowPlaceRaw] = useState([]);
  const auth = useContext(AuthContext);
  const formRef = useRef();

  const dumpOrderItem = Object.assign({
    id: '',
    userId: '',
    bookId: '',
    damageNotes: null,
    borrowedDate: null,
    returnedDate: null,
    placeId: '',
    periodId: ''
  }, qs.parse(window.location.search));

  var queryValues = {
    token: auth.authState.token
  }
  const getOrder = async (id) => {
    try {
      if (id) {
        const { data } = await fetchContext.authAxios.get(
          '/library/order/' + id + '?' + qs.stringify(queryValues)
        );
        setOrder(data);
        formRef.current.values = Object.assign(formRef.current.values, data);
        onClick();
      } else {
        console.log(dumpOrderItem);
        setOrder();
      }
    } catch (err) {
      console.log('the err', err);
    }
  };
  const getUser = async (userId) => {
    try {
      if (userId) {
        const { data } = await fetchContext.authAxios.get(
          '/user/' + userId + '?' + qs.stringify(queryValues)
        );
        setUser(data);
      }
    } catch (err) {
      console.log('the err', err);
      setUser();
    }
  };
  const getBook = async (bookId) => {
    try {
      if (bookId) {
        const { data } = await fetchContext.authAxios.get(
          '/book/' + bookId + '?' + qs.stringify(queryValues)
        );
        setBook(data);
        formRef.current.values.placeId = data.sugeredPlaceId;
        formRef.current.values.periodId = data.sugeredPeriodId;
      }
    } catch (err) {
      console.log('the err', err);
      setBook();
    }
  };

  useEffect(() => {
    const validateUserId = () => {
      if (!librarianMode) {
        dumpOrderItem.userId = auth.authState.userInfo.id;
      }
    };
    const getCoverTypes = async () => {
      try {
        const { data } = await fetchContext.authAxios.get(
          '/dataset/coverType'
        );
        setCoverTypesRaw(data);
      } catch (err) {
        console.log(err);
      }
    };
    const getAuthors = async () => {
      try {
        const { data } = await fetchContext.authAxios.get(
          '/dataset/author'
        );
        setAuthorsRaw(data);
      } catch (err) {
        console.log(err);
      }
    };
    const getBookGenres = async () => {
      try {
        const { data } = await fetchContext.authAxios.get(
          '/dataset/bookGenre'
        );
        setBookGenresRaw(data);
      } catch (err) {
        console.log(err);
      }
    };
    const getBorrowPeriods = async () => {
      try {
        const { data } = await fetchContext.authAxios.get(
          '/dataset/borrowPeriod'
        );
        setBorrowPeriodsRaw(data);
      } catch (err) {
        console.log(err);
      }
    };
    const getBorrowPlace = async () => {
      try {
        const { data } = await fetchContext.authAxios.get(
          '/dataset/borrowPlace'
        );
        setBorrowPlaceRaw(data);
      } catch (err) {
        console.log(err);
      }
    };
    getAuthors();
    getCoverTypes();
    getBookGenres();
    getBorrowPeriods();
    getBorrowPlace();

    validateUserId();
    getOrder(dumpOrderItem.id);
    getUser(dumpOrderItem.userId);
    getBook(dumpOrderItem.bookId);
  }, []);

  function onClick() {
    if (book === undefined ||
      isNaN(formRef.current.values.bookId) ? parseInt(formRef.current.values.bookId, 10) : formRef.current.values.bookId !== book.id) {
      getBook(formRef.current.values.bookId);
    }
    if (user === undefined ||
      isNaN(formRef.current.values.userId) ? parseInt(formRef.current.values.userId, 10) : formRef.current.values.userId != user.id) {
      getUser(formRef.current.values.userId);
    }
  }

  const submitCredentialsLessonItemForm = async credentials => {
    try {
      var saveLessonItem = Object.assign({}, credentials);
      if (order) {
        saveLessonItem.returnedDate = new Date();
      } else {
        saveLessonItem.borrowedDate = new Date();
      }
      console.log(saveLessonItem);

      setSaveLoadingLessonItemForm(true);
      const { data } = saveLessonItem.id ? (
        await fetchContext.authAxios.put(
          `/library/order/` + saveLessonItem.id + '?' + qs.stringify(queryValues),
          saveLessonItem
        )
      ) : (
          await fetchContext.authAxios.post(
            `/library/order` + '?' + qs.stringify(queryValues),
            saveLessonItem
          )
        );
      history.push(data ? "/order?" + qs.stringify({ id: data.id }) : "/find-books");
      setSaveLoadingLessonItemForm(false);

      setSaveSuccessLessonItemForm(data.message);
      setSaveErrorLessonItemForm('');
      if (data) {
        setTimeout(() => {
          window.location.reload();
        }, 700);
      }
    } catch (error) {
      console.log(error);
      setSaveLoadingLessonItemForm(false);
      const { data } = error.response;
      setSaveErrorLessonItemForm(data.message);
      setSaveSuccessLessonItemForm('');
    }
  };

  const SignupSchema = Yup.object().shape({
  });

  return (
    <div>
      <Formik
        initialValues={orderItem ? orderItem : dumpOrderItem}
        onSubmit={values => {
          submitCredentialsLessonItemForm(values);
        }
        }
        validationSchema={SignupSchema}
        innerRef={formRef}
      >
        {({ values, setFieldValue }) => (
          <Form className="">
            {saveSuccessLessonItemForm && (
              <FormSuccess text={saveSuccessLessonItemForm + ' ' + t('components.order_form_component.some_data_visible_in_page_can_stay_unchanged')} />
            )}
            {saveErrorLessonItemForm && (
              <FormError text={saveErrorLessonItemForm} />
            )}
            <input
              type="hidden"
              name="remember"
              value="true"
            />
            <div>
              <div className="flex">
                <div className="mb-2 mr-2 w-1/2">
                  <div className="mb-1">
                    <Label text={t('components.order_form_component.forms.data.user_id')} />
                  </div>
                  <FormInput
                    ariaLabel={t('components.order_form_component.forms.data.user_id')}
                    name="userId"
                    type="number"
                    placeholder={t('components.order_form_component.forms.data.user_id')}
                    onClick={onClick}
                    disabled={disabled ? true : (librarianMode ? (order ? true : false) : true)}
                  />
                </div>
                <div className="mb-2 mr-2 w-1/2">
                  <div className="mb-1">
                    <Label text={t('components.order_form_component.forms.data.book_id')} />
                  </div>
                  <FormInput
                    ariaLabel={t('components.order_form_component.forms.data.book_id')}
                    name="bookId"
                    type="number"
                    placeholder={t('components.order_form_component.forms.data.book_id')}
                    onClick={onClick}
                    disabled={disabled ? true : (librarianMode ? (order ? true : false) : true)}
                  />
                </div>
              </div>
              <div className="border border-green-300 rounded p-3 m-2">
                <Label text={t('components.order_form_component.forms.data.user_overview')} />
                {user ? (
                  <UserOverviewShort userItem={user} />
                ) : (
                    <p>{t('components.order_form_component.forms.data.user_overview_not_found')}</p>
                  )
                }
              </div>
              <div className="border border-green-300 rounded p-3 m-2">
                <Label text={t('components.order_form_component.forms.data.book_overview')} />
                {book ? (
                  <BookItemOverviewShort
                    bookItem={book}
                    authorsRawList={authorsRaw}
                    coverTypesRawList={coverTypesRaw}
                    bookGenresRawList={bookGenresRaw}
                    borrowPeriodsRawList={borrowPeriodsRaw}
                    borrowPlaceRawList={borrowPlaceRaw}
                    borrowButtonDisabled
                  />
                ) : (
                    <p>{t('components.order_form_component.forms.data.book_overview_not_found')}</p>
                  )
                }
              </div>
              <div className="flex">
                <div className="mb-2 mr-2 w-1/2">
                  <div className="mb-1">
                    <Label text={t('components.order_form_component.forms.data.borrowed_date')} />
                  </div>
                  <FormInput
                    ariaLabel={t('components.order_form_component.forms.data.borrowed_date')}
                    name="borrowedDate"
                    type="text"
                    placeholder={t('components.order_form_component.forms.data.borrowed_date')}
                    disabled={true}
                  />
                </div>
                <div className="mb-2 mr-2 w-1/2">
                  <div className="mb-1">
                    <Label text={t('components.order_form_component.forms.data.returned_date')} />
                  </div>
                  <FormInput
                    ariaLabel={t('components.order_form_component.forms.data.returned_date')}
                    name="returnedDate"
                    type="text"
                    placeholder={t('components.order_form_component.forms.data.returned_date')}
                    disabled={true}
                  />
                </div>
              </div>

              <div className="flex">
                <div className="mb-2 mr-2 w-full">
                  <div className="mb-1">
                    <Label text={t('components.order_form_component.forms.data.description')} />
                  </div>
                  <Field
                    className="border border-gray-300 rounded p-2 w-full mb-2"
                    component="textarea"
                    name="damageNotes"
                    placeholder={t('components.order_form_component.forms.data.description_placeholder')}
                    disabled={disabled ? true : (librarianMode ? (order ? (order.returnedDate ? true : false) : true) : true)}
                  />
                </div>
              </div>
            </div>
            <div className="flex items-center">
              <div className="mt-2 mb-2">
                {disabled || order && order.returnedDate ? (
                  <></>
                ) : (
                    librarianMode ? (
                      <GradientButton
                        type="submit"
                        text={order ? t('components.order_form_component.return_book_button') : t('components.order_form_component.borrow_book_button')}
                        loading={saveLoadingLessonItemForm}
                      />
                    ) : (
                        order && order.borrowedDate ? (<></>) : (
                          <GradientButton
                            type="submit"
                            text={t('components.order_form_component.borrow_book_button')}
                            loading={saveLoadingLessonItemForm}
                          />
                        )
                      )
                  )}
              </div>
            </div>

          </Form>
        )}
      </Formik>
    </div>

  );
};

export default OrderForm;
