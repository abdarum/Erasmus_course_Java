import React, { useContext, useState } from 'react';
import * as Yup from 'yup';
import { Formik, Form } from 'formik';
import FormSuccess from './../components/FormSuccess';
import FormError from './../components/FormError';
import Label from '../components/common/Label';
import { useTranslation } from "react-i18next";
import FormInput from '../components/FormInput';
import DatePicker from 'react-date-picker';
import Select from 'react-select';
import GradientButton from '../components/common/GradientButton';
import { FetchContext } from '../context/FetchContext';
import { getEducationLevelSelectOptions } from './EducationLevelSelect';


const AccountPersonalData = ({ user }) => {
  const fetchContext = useContext(FetchContext);
  const [saveSuccessAccountPersonalData, setSaveSuccessAccountPersonalData] = useState();
  const [saveErrorAccountPersonalData, setSaveErrorAccountPersonalData] = useState();
  const { t } = useTranslation('common');
  const [dateOfBirthValue, dateOfBirthOnChange] = useState(new Date(user.dateOfBirth));
  const [saveLoadingAccountPersonalData, setSaveLoadingAccountPersonalData] = useState(false);

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

  const submitCredentialsAccountPersonalData = async credentials => {
    try {
      var saveLessonItem = Object.assign({}, credentials);
      saveLessonItem.educationLevel = credentials.educationLevel.value;
      console.log(saveLessonItem);

      setSaveLoadingAccountPersonalData(true);
      const { data } = await fetchContext.authAxios.put(
        `/v1/users`,
        saveLessonItem
      );
      setSaveLoadingAccountPersonalData(false);

      setSaveSuccessAccountPersonalData(data.message);
      setSaveErrorAccountPersonalData('');
    } catch (error) {
      setSaveLoadingAccountPersonalData(false);
      const { data } = error.response;
      setSaveErrorAccountPersonalData(data.message);
      setSaveSuccessAccountPersonalData('');
    }
  };

  const SignupSchema = Yup.object().shape({
    // // dateOfBirth: Yup.date().required("not working"),
    // // educationLevel: Yup.string().required("bababab"),
    firstName: Yup.string().required(t('components.account_personal_data_info_component.forms.validation.first_name_is_required')),
    lastName: Yup.string().required(t('components.account_personal_data_info_component.forms.validation.last_name_is_required'))
  });

  return (
    <Formik
      initialValues={{
        firstName: user.firstName,
        lastName: user.lastName,
        educationLevel: translateOptions(getEducationLevelSelectOptions(user.educationLevel)),
        dateOfBirth: user.dateOfBirth
      }}
      onSubmit={values => {
        values.dateOfBirth = dateOfBirthValue;
        submitCredentialsAccountPersonalData(values);
      }
      }
      validationSchema={SignupSchema}
    >
      {({ values, setFieldValue }) => (
        <Form className="mt-4">
          {saveSuccessAccountPersonalData && (
            <FormSuccess text={saveSuccessAccountPersonalData + ' ' + t('components.account_personal_data_info_component.some_data_visible_in_page_can_stay_unchanged')} />
          )}
          {saveErrorAccountPersonalData && (
            <FormError text={saveErrorAccountPersonalData} />
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
                  <Label text={t('components.account_personal_data_info_component.forms.data.first_name')} />
                </div>
                <FormInput
                  ariaLabel={t('components.account_personal_data_info_component.forms.data.first_name')}
                  name="firstName"
                  type="text"
                  placeholder={t('components.account_personal_data_info_component.forms.data.first_name')}
                />
              </div>
              <div className="mb-2 ml-2 w-1/2">
                <div className="mb-1">
                  <Label text={t('components.account_personal_data_info_component.forms.data.last_name')} />
                </div>
                <FormInput
                  ariaLabel={t('components.account_personal_data_info_component.forms.data.last_name')}
                  name="lastName"
                  type="text"
                  placeholder={t('components.account_personal_data_info_component.forms.data.last_name')}
                />
              </div>
            </div>
            <div className="flex">
              <div className="mb-2 mr-2 w-1/2">
                <div className="mb-1">
                  <Label text={t('components.account_personal_data_info_component.forms.data.date_of_birth')} />
                </div>
                <DatePicker
                  onChange={dateOfBirthOnChange}
                  value={dateOfBirthValue}
                />
              </div>
              <div className="mb-2 ml-2 w-1/2">
                <div className="mb-1">
                  <Label text={t('components.account_personal_data_info_component.forms.data.education_level')} />
                </div>
                <Select
                  name="educationLevel"
                  id="educationLevel"
                  value={values.educationLevel}
                  options={translateOptions(getEducationLevelSelectOptions())}
                  onChange={(opt, e) => {
                    setFieldValue("educationLevel", opt);
                  }} />
              </div>
            </div>
          </div>

          <div className="flex">
            <div className="mt-2 mb-2">
              <GradientButton
                type="submit"
                text={t('components.account_personal_data_info_component.save_button')}
                loading={saveLoadingAccountPersonalData}
              />
            </div>
          </div>
        </Form>
      )}
    </Formik>

  );
};

export default AccountPersonalData;
