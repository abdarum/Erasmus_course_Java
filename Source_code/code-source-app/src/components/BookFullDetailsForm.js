import React, { useContext, useState, useEffect } from 'react';
import * as Yup from 'yup';
import { Formik, Form, Field } from 'formik';
import FormSuccess from './FormSuccess';
import FormError from './FormError';
import Label from './common/Label';
import { useTranslation } from "react-i18next";
import FormInput from './FormInput';
import DatePicker from 'react-date-picker';
import Select from 'react-select';
import GradientButton from './common/GradientButton';
import { FetchContext } from '../context/FetchContext';
import { AuthContext } from '../context/AuthContext';
import { getAuthorSelectOptions, getAuthorDatabaseValues } from './AuthorSelect';
import { getStatusSelectOptions, getStatusDatabaseValues } from './StatusSelect';
import qs from 'query-string';


const BookFullDetailsForm = ({ book, authorsRawList, key, statusSelectAvailable }) => {
  const fetchContext = useContext(FetchContext);
  const auth = useContext(AuthContext);
  const [saveSuccessBookFullDetailsForm, setSaveSuccessBookFullDetailsForm] = useState();
  const [saveErrorBookFullDetailsForm, setSaveErrorBookFullDetailsForm] = useState();
  const { t } = useTranslation('common');
  const [saveLoadingBookFullDetailsForm, setSaveLoadingBookFullDetailsForm] = useState(false);


  useEffect(() => {
    if (book !== undefined) {
      console.log(book.status);
    }

  }, []);

  const dumpBookInfo = {
    id: null,
    name: '',
    isbn: '',
    authorId: '',
    pageCount: '',
    coverTypeId: '',
    genreId: '',
    sugeredPeriodId: '',
    sugeredPlaceId: '',
    status: 'available'
  };

  function prepareFormData(bookItem) {
    var processedBook = Object.assign({}, bookItem);
    processedBook.authorId = bookItem.authorId ? getAuthorSelectOptions(authorsRawList, bookItem.authorId) : bookItem.authorId;
    // processedBook.status = bookItem.status ? translateOptions(getStatusSelectOptions(bookItem.status)) : bookItem.status;
    return processedBook;
  }

  function translateOptions(options) {
    if (Array.isArray(options)) {
      options.forEach(function (entry) {
        if (entry.label !== undefined) {
          entry.label = t(entry.label);
        }
        if (entry.options !== undefined) {
          entry.options.forEach(function (entry) {
            if (entry.label !== undefined) {
              entry.label = t(entry.label);
            }
          });
        }
      });
      return options;
    } else {
      if (options.label !== undefined) {
        options.label = t(options.label);
      }
      return options;
    }
  }

  const submitCredentialsBookFullDetailsForm = async credentials => {
    try {
      var saveBookItem = Object.assign({}, credentials);
      saveBookItem.authorId = getAuthorDatabaseValues(credentials.authorId);
      // saveBookItem.status = getStatusDatabaseValues(credentials.status);
      console.log(saveBookItem);

      var queryValues = {
        token: auth.authState.token
      }
      setSaveLoadingBookFullDetailsForm(true);
      const { data } = credentials.id ? (
        await fetchContext.authAxios.put(
          `/book/` + credentials.id + '?' + qs.stringify(queryValues),
          saveBookItem
        )
      ) : (
          await fetchContext.authAxios.post(
            `/book?` + qs.stringify(queryValues),
            saveBookItem
          )
        );
      setSaveLoadingBookFullDetailsForm(false);

      setSaveSuccessBookFullDetailsForm(data.message);
      setSaveErrorBookFullDetailsForm('');
    } catch (error) {
      console.log(error);
      setSaveLoadingBookFullDetailsForm(false);
      const { data } = error.response;
      setSaveErrorBookFullDetailsForm(data.message);
      setSaveSuccessBookFullDetailsForm('');
    }
  };

  const SignupSchema = Yup.object().shape({
  });

  return (
    <Formik
      initialValues={book ? prepareFormData(book) : prepareFormData(dumpBookInfo)}
      onSubmit={values => {
        submitCredentialsBookFullDetailsForm(values);
      }
      }
      validationSchema={SignupSchema}
    >
      {({ values, setFieldValue }) => (
        <Form className="mt-4">
          {saveSuccessBookFullDetailsForm && (
            <FormSuccess text={saveSuccessBookFullDetailsForm} />
          )}
          {saveErrorBookFullDetailsForm && (
            <FormError text={saveErrorBookFullDetailsForm} />
          )}
          <input
            type="hidden"
            name="remember"
            value="true"
          />
          <div>
            <div className="flex justify-between">
              <div className="mb-2 px-1 w-1/4">
                {values.id ? (
                  <p className="font-bold text-lg">{t('components.book_full_details_form_component.book_id_header') + values.id}</p>
                ) : (
                    <p className="font-bold text-lg">{t('components.book_full_details_form_component.new_book_header')}</p>
                  )}
              </div>
              <div className="mb-2 px-1 flex items-center">
                {statusSelectAvailable ? (
                  <div>
                    <div className="mb-1 mr-2">
                      <Label text={t('components.user_full_details_form_component.forms.data.status_select')} />
                    </div>
                    <FormInput
                      ariaLabel={t('components.book_full_details_form_component.forms.data.status')}
                      name="status"
                      type="text"
                      placeholder={t('components.book_full_details_form_component.forms.data.status')}
                    />
                  </div>
                ) : (
                    <div className="mb-1 mr-2">
                      <Label text={t('components.user_full_details_form_component.forms.data.status') + values.status} />
                    </div>
                  )}
              </div>
            </div>
            <div className="flex">
              <div className="mb-2 px-1 w-1/4">
                <div className="mb-1">
                  <Label text={t('components.book_full_details_form_component.forms.data.name')} />
                </div>
                <FormInput
                  ariaLabel={t('components.book_full_details_form_component.forms.data.name')}
                  name="name"
                  type="text"
                  placeholder={t('components.book_full_details_form_component.forms.data.name')}
                />
              </div>
              <div className="mb-2 px-1 w-1/4">
                <div className="mb-1">
                  <Label text={t('components.book_full_details_form_component.forms.data.isbn')} />
                </div>
                <FormInput
                  ariaLabel={t('components.book_full_details_form_component.forms.data.isbn')}
                  name="isbn"
                  type="text"
                  placeholder={t('components.book_full_details_form_component.forms.data.isbn')}
                />
              </div>
              <div className="mb-2 px-1 w-1/4">
                <div className="mb-1">
                  <Label text={t('components.book_full_details_form_component.forms.data.author_id')} />
                </div>
                {authorsRawList ? (
                  <Select
                    name="status"
                    id="status"
                    value={values.authorId}
                    options={getAuthorSelectOptions(authorsRawList)}
                    onChange={(opt, e) => {
                      setFieldValue("authorId", opt);
                    }} />
                ) : (
                    <p>Loading ...</p>
                  )}
              </div>
              <div className="mb-2 px-1 w-1/4">
                <div className="mb-1">
                  <Label text={t('components.book_full_details_form_component.forms.data.page_count')} />
                </div>
                <FormInput
                  ariaLabel={t('components.book_full_details_form_component.forms.data.page_count')}
                  name="pageCount"
                  type="number"
                  placeholder={t('components.book_full_details_form_component.forms.data.page_count')}
                />
              </div>
            </div>
            <div className="flex">
              <div className="mb-2 px-1 w-1/4">
                <div className="mb-1">
                  <Label text={t('components.book_full_details_form_component.forms.data.cover_type_id')} />
                </div>
                <FormInput
                  ariaLabel={t('components.book_full_details_form_component.forms.data.cover_type_id')}
                  name="coverTypeId"
                  type="number"
                  placeholder={t('components.book_full_details_form_component.forms.data.cover_type_id')}
                />
              </div>
              <div className="mb-2 px-1 w-1/4">
                <div className="mb-1">
                  <Label text={t('components.book_full_details_form_component.forms.data.genre_id')} />
                </div>
                <FormInput
                  ariaLabel={t('components.book_full_details_form_component.forms.data.genre_id')}
                  name="genreId"
                  type="number"
                  placeholder={t('components.book_full_details_form_component.forms.data.genre_id')}
                />
              </div>
              <div className="mb-2 px-1 w-1/4">
                <div className="mb-1">
                  <Label text={t('components.book_full_details_form_component.forms.data.sugered_period_id')} />
                </div>
                <FormInput
                  ariaLabel={t('components.book_full_details_form_component.forms.data.sugered_period_id')}
                  name="sugeredPeriodId"
                  type="number"
                  placeholder={t('components.book_full_details_form_component.forms.data.sugered_period_id')}
                />
              </div>
              <div className="mb-2 px-1 w-1/4">
                <div className="mb-1">
                  <Label text={t('components.book_full_details_form_component.forms.data.sugered_place_id')} />
                </div>
                <FormInput
                  ariaLabel={t('components.book_full_details_form_component.forms.data.sugered_place_id')}
                  name="sugeredPlaceId"
                  type="number"
                  placeholder={t('components.book_full_details_form_component.forms.data.sugered_place_id')}
                />
              </div>
            </div>
          </div>

          <div className="flex">
            <div className="mt-2 mb-2">
              <GradientButton
                type="submit"
                text={t('components.book_full_details_form_component.save_button')}
                loading={saveLoadingBookFullDetailsForm}
              />
            </div>
          </div>
        </Form>
      )
      }
    </Formik >

  );
};

export default BookFullDetailsForm;
