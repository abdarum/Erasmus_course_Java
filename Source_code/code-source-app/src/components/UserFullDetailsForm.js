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
import { getUserTypeSelectOptions } from './UserTypeSelect';
import { getStatusSelectOptions } from './StatusSelect';


const UserFullDetailsForm = ({ user, userTypeId, key }) => {
  const fetchContext = useContext(FetchContext);
  const auth = useContext(AuthContext);
  const [saveSuccessReaderForm, setSaveSuccessReaderForm] = useState();
  const [saveErrorReaderForm, setSaveErrorReaderForm] = useState();
  const { t } = useTranslation('common');
  const [saveLoadingReaderForm, setSaveLoadingReaderForm] = useState(false);


  useEffect(() => {
    console.log(user);
  }, []);

  const dumpUserInfo = {
    id: null,
    firstName: '',
    lastName: '',
    status: 'active',
    userTypeId: userTypeId ? userTypeId : auth.getReaderUserTypeId,
    phone: '',
    email: '',
    password: '',
    birthdate: '',
    gender: '',
    address: '',
    city: ''
  };

  function prepareFormData(user) {
    var processedUser = Object.assign({}, user);
    processedUser.userTypeId = user.userTypeId ? translateOptions(getUserTypeSelectOptions(user.userTypeId)) : user.userTypeId;
    processedUser.status = user.status ? translateOptions(getStatusSelectOptions(user.status)) : user.status;
    return processedUser;
  }

  function translateOptions(options) {
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
  }

  const submitCredentialsReaderForm = async credentials => {
    try {
      var saveLessonItem = Object.assign({}, credentials);
      saveLessonItem.userTypeId = credentials.userTypeId.value ? credentials.userTypeId.value : null;
      saveLessonItem.status = credentials.status.value ? credentials.status.value : null;
      console.log(saveLessonItem);

      setSaveLoadingReaderForm(true);
      const { data } = credentials.id ? (
        await fetchContext.authAxios.put(
          `/user/` + credentials.id,
          saveLessonItem
        )
      ) : (
          await fetchContext.authAxios.post(
            `/user`,
            saveLessonItem
          )
        );
      setSaveLoadingReaderForm(false);

      setSaveSuccessReaderForm(data.message);
      setSaveErrorReaderForm('');
    } catch (error) {
      setSaveLoadingReaderForm(false);
      const { data } = error.response;
      setSaveErrorReaderForm(data.message);
      setSaveSuccessReaderForm('');
    }
  };

  const SignupSchema = Yup.object().shape({
    firstName: Yup.string().required(t('components.user_full_details_form_component.forms.validation.first_name_is_required')),
    lastName: Yup.string().required(t('components.user_full_details_form_component.forms.validation.last_name_is_required'))
  });

  return (
    <Formik
      initialValues={user ? prepareFormData(user) : prepareFormData(dumpUserInfo)}
      onSubmit={values => {
        submitCredentialsReaderForm(values);
      }
      }
      validationSchema={SignupSchema}
    >
      {({ values, setFieldValue }) => (
        <Form className="mt-4">
          {saveSuccessReaderForm && (
            <FormSuccess text={saveSuccessReaderForm + ' ' + t('components.user_full_details_form_component.some_data_visible_in_page_can_stay_unchanged')} />
          )}
          {saveErrorReaderForm && (
            <FormError text={saveErrorReaderForm} />
          )}
          <input
            type="hidden"
            name="remember"
            value="true"
          />
          <div>
            {values.id ? (
              <p className="font-bold text-lg">{t('components.user_full_details_form_component.user_id_header') + values.id}</p>
            ) : (
                <p className="font-bold text-lg">{t('components.user_full_details_form_component.new_user_header')}</p>
              )}
            <div className="flex">
              <div className="mb-2 px-1 w-1/4">
                <div className="mb-1">
                  <Label text={t('components.user_full_details_form_component.forms.data.first_name')} />
                </div>
                <FormInput
                  ariaLabel={t('components.user_full_details_form_component.forms.data.first_name')}
                  name="firstName"
                  type="text"
                  placeholder={t('components.user_full_details_form_component.forms.data.first_name')}
                />
              </div>
              <div className="mb-2 px-1 w-1/4">
                <div className="mb-1">
                  <Label text={t('components.user_full_details_form_component.forms.data.last_name')} />
                </div>
                <FormInput
                  ariaLabel={t('components.user_full_details_form_component.forms.data.last_name')}
                  name="lastName"
                  type="text"
                  placeholder={t('components.user_full_details_form_component.forms.data.last_name')}
                />
              </div>
              <div className="mb-2 px-1 w-1/4">
                <div className="mb-1">
                  <Label text={t('components.user_full_details_form_component.forms.data.status')} />
                </div>
                <Select
                  name="status"
                  id="status"
                  value={values.status}
                  options={translateOptions(getStatusSelectOptions())}
                  onChange={(opt, e) => {
                    setFieldValue("status", opt);
                  }} />
              </div>
              {userTypeId ? (<p />) : (
                <div className="mb-2 px-1 w-1/4">

                  <div className="mb-1">
                    <Label text={t('components.user_full_details_form_component.forms.data.user_type')} />
                  </div>
                  <Select
                    name="userTypeId"
                    id="userTypeId"
                    value={values.userTypeId}
                    options={translateOptions(getUserTypeSelectOptions())}
                    onChange={(opt, e) => {
                      setFieldValue("userTypeId", opt);
                    }} />
                </div>
              )}
            </div>
            <div className="flex">
              <div className="mb-2 px-1 w-1/4">
                <div className="mb-1">
                  <Label text={t('components.user_full_details_form_component.forms.data.phone')} />
                </div>
                <FormInput
                  ariaLabel={t('components.user_full_details_form_component.forms.data.phone')}
                  name="phone"
                  type="text"
                  placeholder={t('components.user_full_details_form_component.forms.data.phone')}
                />
              </div>
              <div className="mb-2 px-1 w-1/4">
                <div className="mb-1">
                  <Label text={t('components.user_full_details_form_component.forms.data.email')} />
                </div>
                <FormInput
                  ariaLabel={t('components.user_full_details_form_component.forms.data.email')}
                  name="email"
                  type="email"
                  placeholder={t('components.user_full_details_form_component.forms.data.email')}
                />
              </div>
              <div className="mb-2 mr-2 w-1/4">
                <div className="mb-1">
                  <Label text={t('components.user_full_details_form_component.forms.data.password')} />
                </div>
                <FormInput
                  ariaLabel={t('components.user_full_details_form_component.forms.data.password')}
                  name="password"
                  type="password"
                  placeholder={t('components.user_full_details_form_component.forms.data.password')}
                />
              </div>
              <div className="mb-2 ml-2 w-1/4">
              </div>
            </div>
            <div className="flex">
              <div className="mb-2 px-1 w-1/4">
                <div className="mb-1">
                  <Label text={t('components.user_full_details_form_component.forms.data.birthdate')} />
                </div>
                <DatePicker
                  onChange={
                    (value) => {
                      setFieldValue("birthdate", value);
                    }}
                  value={values.birthdate}
                />
              </div>
              <div className="mb-2 px-1 w-1/4">
                <div className="mb-1">
                  <Label text={t('components.user_full_details_form_component.forms.data.gender')} />
                </div>
                <div className="flex justify-evenly mr-3">
                  <p><Field type="radio" value="male" name="gender" /> {t('datasets.gender.values.male')}</p>
                  <p><Field type="radio" value="female" name="gender" /> {t('datasets.gender.values.female')}</p>
                  <p><Field type="radio" value="other" name="gender" /> {t('datasets.gender.values.other')}</p>
                </div>
              </div>
              <div className="mb-2 mr-2 w-1/4">
                <div className="mb-1">
                  <Label text={t('components.user_full_details_form_component.forms.data.address')} />
                </div>
                <FormInput
                  ariaLabel={t('components.user_full_details_form_component.forms.data.address')}
                  name="address"
                  type="text"
                  placeholder={t('components.user_full_details_form_component.forms.data.address')}
                />
              </div>
              <div className="mb-2 ml-2 w-1/4">
                <div className="mb-1">
                  <Label text={t('components.user_full_details_form_component.forms.data.city')} />
                </div>
                <FormInput
                  ariaLabel={t('components.user_full_details_form_component.forms.data.city')}
                  name="city"
                  type="text"
                  placeholder={t('components.user_full_details_form_component.forms.data.city')}
                />
              </div>
            </div>
          </div>

          <div className="flex">
            <div className="mt-2 mb-2">
              <GradientButton
                type="submit"
                text={t('components.user_full_details_form_component.save_button')}
                loading={saveLoadingReaderForm}
              />
            </div>
          </div>
        </Form>
      )
      }
    </Formik >

  );
};

export default UserFullDetailsForm;
