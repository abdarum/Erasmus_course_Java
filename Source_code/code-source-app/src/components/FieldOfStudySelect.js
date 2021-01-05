const getFieldOfStudySelectOptions = (initArray) => {
    const fieldOfStudyValues = {
        languages: [
            "lan_english",
            "lan_german",
            "lan_french",
            "lan_russian",
            "lan_spanish",
            "lan_italian",
            "lan_polish",
            "lan_polish_for_foreigners",
            "lan_other"
        ],
        humanities: [
            "hum_history",
            "hum_civics",
            "hum_art_history",
            "hum_other"
        ],
        science: [
            "sci_mathematics",
            "sci_chemistry",
            "sci_physics",
            "sci_biology",
            "sci_geography",
            "sci_statistics",
            "sci_other"
        ],
        it_fields: [
            "compsci_informatics",
            "compsci_computer_use",
            "compsci_programming",
            "compsci_other"
        ],
        art: [
            "art_musical_instruments",
            "art_music",
            "art_drawing",
            "art_other"
        ],
        other: [
            "other_primary_learning",
            "other_other"
        ]
    }


    const fieldOfStudyValuesSelect = [];

    function setFieldOfStudySelect() {
        if (initArray !== undefined) {
            for (const [key, value] of Object.entries(fieldOfStudyValues)) {
                value.forEach(function (entry) {
                    if (initArray.includes(entry)) {
                        fieldOfStudyValuesSelect.push({ value: `${entry}`, label: 'datasets.field_of_study.values.' + `${entry}` });
                    }
                });
            }
        } else {
            var groupEntry;
            for (const [key, value] of Object.entries(fieldOfStudyValues)) {
                groupEntry = { label: 'datasets.field_of_study.groups.' + `${key}`, options: [] }
                value.forEach(function (entry) {
                    groupEntry.options.push({ value: `${entry}`, label: 'datasets.field_of_study.values.' + `${entry}` });
                });
                fieldOfStudyValuesSelect.push(groupEntry);
            }
        }
    }

    setFieldOfStudySelect();

    return (fieldOfStudyValuesSelect);
};

const getFieldOfStudyDatabaseValues = (initArray) => {
    var returnValue = initArray.value;
    return returnValue;
}

export { getFieldOfStudySelectOptions, getFieldOfStudyDatabaseValues };