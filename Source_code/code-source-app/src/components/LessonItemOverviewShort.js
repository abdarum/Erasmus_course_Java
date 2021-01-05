import React, { useEffect } from 'react';
import { useTranslation } from "react-i18next";
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faLightbulb } from '@fortawesome/free-solid-svg-icons';

const LessonItemOverviewShort = ({ lessonItem }) => {
  const { t } = useTranslation('common');

  useEffect(() => {
    // console.log(lessonItem);
  }, []);

  const dumpLessonItem = {
    _id: undefined,
    teacherId: '', // get teacher id from logged in user
    fieldOfStudy: '',
    educationLevel: [],
    teachingLanguages: [],
    hourlyRate: 0,
    onlineModeEnable: true,
    faceToFaceModeStudentPlaceEnable: true,
    faceToFaceModeTeacherPlaceEnable: true,
    places: [],
    description: ""
  };

  return (
    <div>
      <div className="flex items-center">
        <div className="mt-2 mb-2 mr-2">
          <p className="font-bold">{t('datasets.field_of_study.values.' + lessonItem.fieldOfStudy)}</p>
        </div>
        {lessonItem.firstFreeLessonEnable ? (
          <div className="rounded border border-orange-600 px-2 flex">
            <p className="text-orange-600 text-base text-right"><FontAwesomeIcon icon={faLightbulb} /> {t('components.lesson_item_overview_short_component.labels.first_free_lesson_enable')}</p>
          </div>
        ) : (<div />)}
        <div className="flex">
          {lessonItem.educationLevel && lessonItem.educationLevel.length ? (
            lessonItem.educationLevel.map(item => (
              <p className="text-gray-600 text-sm rounded border border-blue-600 px-2 ml-2">{t('datasets.education_level.values.' + item)}</p>
            ))
          ) : (<div />)}
        </div>
      </div >
      <div className="flex items-center justify-between">
        <div className="rounded border border-blue-600 px-2 m-1">
          <p className="text-gray-600 text-base text-center">{t('components.lesson_item_overview_short_component.labels.hourly_rate')}</p>
          <p className="text-gray-600 text-4xl text-center">{lessonItem.hourlyRate}</p>
        </div>
        <div className="rounded border border-blue-600 px-2 m-1 py-2">
          <p className="text-gray-600 text-base text-center">{t('components.lesson_item_overview_short_component.labels.teaching_languages')}</p>
          {lessonItem.teachingLanguages && lessonItem.teachingLanguages.length ? (
            lessonItem.teachingLanguages.map(item => (
              <p className="text-gray-600 text-sm rounded border border-blue-600 px-2 ml-2">{t('datasets.teaching_languages.values.' + item)}</p>
            ))
          ) : (<div />)}
        </div>
        <div className="rounded border border-blue-600 px-2 m-1">
          <p className="text-gray-600 text-base text-center">{t('components.lesson_item_overview_short_component.labels.rating')}</p>
          <p className="text-gray-600 text-4xl text-center">{lessonItem.numberOfFeedbacks ? lessonItem.rating : t('components.lesson_item_overview_short_component.labels.no_feedbacks_value')}</p>
          <p className="text-gray-600 text-sm text-center">{lessonItem.numberOfFeedbacks ? t('components.lesson_item_overview_short_component.labels.number_of_feedbacks') + lessonItem.numberOfFeedbacks : t('components.lesson_item_overview_short_component.labels.no_feedbacks_description')}</p>
        </div>
      </div>
      <div className="flex items-center justify-between">
        {lessonItem.onlineModeEnable ? (
          <div className="rounded border border-blue-600 px-2 m-1">
            <p className="text-gray-600 text-base text-center">{t('components.lesson_item_overview_short_component.labels.online_mode_enable')}</p>
          </div>
        ) : (<div />)}
        {lessonItem.phoneNumber ? (
          <div className="rounded border border-blue-600 px-2 m-1">
            <p className="text-gray-600 text-base text-center">{t('components.lesson_item_overview_short_component.labels.phone_number') + lessonItem.phoneNumber}</p>
          </div>
        ) : (<div />)}
        {lessonItem.email ? (
          <div className="rounded border border-blue-600 px-2 m-1">
            <p className="text-gray-600 text-base text-center">{t('components.lesson_item_overview_short_component.labels.email_address') + lessonItem.email}</p>
          </div>
        ) : (<div />)}
      </div >
    </div >

  );
};

export default LessonItemOverviewShort;
