const getTeachingLanguagesSelectOptions = (initArray) => {
    const teachingLanguagesValues = [
        "teach_lan_polish",
        "teach_lan_english",
        "teach_lan_german",
        "teach_lan_spanish",
        "teach_lan_italian",
        "teach_lan_french",
        "teach_lan_russian",
        "teach_lan_ukrainian"
    ]

    const teachingLanguagesValuesSelect = [];

    function setTeachingLanguagesSelect() {
        teachingLanguagesValues.forEach(function (entry) {
            if (initArray !== undefined) {
                if (initArray.includes(entry)) {
                    teachingLanguagesValuesSelect.push({ value: `${entry}`, label: 'datasets.teaching_languages.values.' + `${entry}` });
                }
            } else {
                teachingLanguagesValuesSelect.push({ value: `${entry}`, label: 'datasets.teaching_languages.values.' + `${entry}` });
            }
        })
    }

    setTeachingLanguagesSelect();

    return (teachingLanguagesValuesSelect);
};

const getTeachingLanguagesDatabaseValues = (initArray) => {
    var returnValuesArray = []
    initArray.forEach(function (entry) {
        returnValuesArray.push(entry.value);
    });
    return returnValuesArray;
}
export  {getTeachingLanguagesSelectOptions, getTeachingLanguagesDatabaseValues};
