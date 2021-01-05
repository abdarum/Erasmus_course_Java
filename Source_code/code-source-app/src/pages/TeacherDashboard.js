import React, { useState, useContext, useEffect } from 'react';
import PageTitle from '../components/common/PageTitle';
import Card from '../components/common/Card';
import { FetchContext } from '../context/FetchContext';
import { useTranslation } from "react-i18next";
import TeacherContactData from './../components/TeacherContactData';
import LessonItemForm from '../components/LessonItemForm';
import { Collapse } from 'react-collapse';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faChevronCircleDown, faChevronCircleUp } from '@fortawesome/free-solid-svg-icons';

const TeacherDashboard = () => {
  const fetchContext = useContext(FetchContext);
  const { t } = useTranslation('common');
  const [userData, setUserData] = useState();
  const [lessonItems, setLessonItems] = useState([]);
  const [teacherContactDataVisible, setTeacherContactDataVisible] = useState(true);

  const getUserData = async () => {
    try {
      const { data } = await fetchContext.authAxios.get(
        '/v1/users'
      );
      setUserData(data.user);
    } catch (err) {
      console.log(err);
    }
  };

  const getLessonItemsData = async () => {
    try {
      const { data } = await fetchContext.authAxios.get(
        '/v1/users/lessons'
      );
      setLessonItems(data);
      setTeacherContactDataVisible(data.length ? false : true);
    } catch (err) {
      console.log(err);
    }
  };

  useEffect(() => {
    getLessonItemsData();
    getUserData();
  }, [fetchContext]);

  function toggleTeacherContactDataVisible() {
    setTeacherContactDataVisible(!teacherContactDataVisible);
  }


  return (
    <>
      <PageTitle title={t('pages.teacher_dashboard_page.title')} />
      {userData ? (
        <>
          <Card>
            <p className="font-bold">{t('pages.teacher_dashboard_page.teacher_info_section.header')}</p>
            <Collapse isOpened={teacherContactDataVisible}>
              {userData && (
                <TeacherContactData
                  user={userData}
                  onChange={() => {
                    getUserData();
                  }}
                />
              )}
            </Collapse>
            {!teacherContactDataVisible ? <div className="flex">
              <p className="text-gray-600 text-sm mt-4">{t('pages.teacher_dashboard_page.teacher_info_section.collapsed_description')}</p>
            </div> : <p></p>}
            <button
              className="text-gray-700 mr-3 mb-3 flex"
              onClick={() => toggleTeacherContactDataVisible()}
              style={{ marginLeft: "auto" }}
            >
              <div className="flex">
                <p className="text-sm w-auto">{teacherContactDataVisible ? t('pages.teacher_dashboard_page.teacher_info_section.collapse_button') : t('pages.teacher_dashboard_page.teacher_info_section.expand_button')}</p>
                <FontAwesomeIcon className="ml-2 w-auto" icon={teacherContactDataVisible ? faChevronCircleUp : faChevronCircleDown} size="lg" />
              </div>
            </button>
          </Card>
          <br />
          {lessonItems && lessonItems.length
            ? lessonItems.map(item => (
              <div>
                <Card>
                  <LessonItemForm
                    lessonItem={item}
                  />
                </Card>
                <br />
              </div>
            ))
            : (
              <div>
                <Card>
                  <p className='ml-3'>{t('pages.teacher_dashboard_page.existing_lesson_items_section.no_lesson_items')}</p>
                </Card>
              </div>
            )}
          <br />
          {userData.contactInfo ? (
            <Card>
              <p className="font-bold">{t('pages.teacher_dashboard_page.new_lesson_item_section.header')}</p>
              <LessonItemForm
                lessonItem={undefined}
              />
            </Card>
          ) : (
              <Card>
                <p className='ml-3 font-bold'>{t('pages.teacher_dashboard_page.new_lesson_item_section.add_contact_info_before')}</p>
              </Card>
            )}
        </>
      ) : (
          <p>Loading...</p>
        )}
      <br />
    </>
  );
};

export default TeacherDashboard;
