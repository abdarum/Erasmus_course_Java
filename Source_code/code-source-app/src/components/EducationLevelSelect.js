const getEducationLevelSelectOptions = (initArray) => {
    const educationLevelValues = {
        level1Options: [
            "pl_level1_group_1",
            "pl_level1_group_2"
        ],
        level2Options: [
            "pl_level2_element_1",
            "pl_level2_element_2"
        ],
        level3Options: [
            "pl_level3_element_1",
            "pl_level3_element_2",
            "pl_level3_element_3"
        ],
        level4Options: [
            "pl_level4_element_1"
        ]
    }

    const educationLevelValuesSelect = [];

    function setEducationLevelSelect() {
        if (initArray !== undefined) {
            for (const [key, value] of Object.entries(educationLevelValues)) {
                value.forEach(function (entry) {
                    if (initArray.includes(entry)) {
                        educationLevelValuesSelect.push({ value: `${entry}`, label: 'datasets.education_level.values.' + `${entry}` });
                    }
                });
            }
        } else {
            var groupEntry;
            for (const [key, value] of Object.entries(educationLevelValues)) {
                groupEntry = { label: 'datasets.education_level.groups.' + `${key}`, options: [] }
                value.forEach(function (entry) {
                    groupEntry.options.push({ value: `${entry}`, label: 'datasets.education_level.values.' + `${entry}` });
                });
                educationLevelValuesSelect.push(groupEntry);
            }
        }
    }

    setEducationLevelSelect();

    return (educationLevelValuesSelect);
};

const getEducationLevelDatabaseValues = (initArray) => {
    if(initArray === null){
        return [];
    } else {
        var returnValuesArray = []
        initArray.forEach(function (entry) {
            returnValuesArray.push(entry.value);
        });
        return returnValuesArray;
    }
}

export { getEducationLevelSelectOptions, getEducationLevelDatabaseValues };
