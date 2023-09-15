package com.tmf.cruisefinderaipoc1.testdata

const val testSearchScreenLayout = """
{
  "Controls": [
    {
      "Control": "Button",
      "ID": "btnFindCruises",
      "Label": "FIND CRUISES",
      "OnClick": "FindCruises"
    },
    {
      "Control": "Group",
      "ID": "grpTravelers",
      "Icon": "travelersIcon",
      "Label": "Travelers",
      "Text": "{Value:NumberOfAdults} adults{IfNonZero:NumberOfChildren|, {Value:NumberOfChildren} children}",
      "Controls": [
        {
          "Control": "Group",
          "ID": "grpTraveler",
          "Icon": "travelerIcon",
          "Label": "Primary traveler",
          "Text": "{Value:PrimaryTravelerFirstName} {Value:PrimaryTravelerLastName}",
          "Controls": [
            {
              "Control": "TextInput",
              "Label": "First name",
              "Text": "{Value}",
              "Hint": "Enter first name",
              "BoundValue": "PrimaryTravelerFirstName",
              "Validate": "^(?!\\s*${'$'}).+"
            },
            {
              "Control": "TextInput",
              "Label": "Last name",
              "Text": "{Value}",
              "Hint": "Enter last name",
              "BoundValue": "PrimaryTravelerLastName",
              "Validate": "^(?!\\s*${'$'}).+"
            },
            {
              "Control": "TextInput",
              "Label": "Primary traveler's zip code",
              "Text": "{Value}",
              "Validate": "\\d{5}",
              "Hint": "99999",
              "BoundValue": "PrimaryZipCode"
            },
            {
              "Control": "Date",
              "Label": "Oldest traveler's birth date",
              "Text": "{Value}",
              "BoundValue": "OldestTravelerBirthDate"
            }
          ]
        },
        {
          "Control": "Dropdown",
          "ID": "NumberOfAdults",
          "Label": "Number of adults",
          "Text": "{Value}",
          "BoundValue": "NumberOfAdults",
          "Choices": "2|3|4",
          "DefaultValue": "2"
        },
        {
          "Control": "Dropdown",
          "ID": "NumberOfChildren",
          "Label": "Number of children (age 0-17)",
          "Text": "{Value}",
          "BoundValue": "NumberOfChildren",
          "Choices": "0|1|2|3",
          "DefaultValue": "1"
        },
        {
          "Control": "Group",
          "ID": "grpLoyalty",
          "Label": "Loyalty programs",
          "Text": "{ListChildrenNonEmptyNone:Label|{Value}}",
          "Controls": [
            {
              "Control": "LoyaltyTextInput",
              "Icon": "CarnivalIconTiny",
              "Label": "Carnival Cruise Line",
              "Text": "{Value}",
              "BoundValue": "CarnivalLoyaltyNumber",
              "OnClickArgs": "cruiseline='Carnival',firstName='{Value:PrimaryTravelerFirstName}',lastName='{Value:PrimaryTravelerLastName}',zipcode='{Value:ZipCode}'"
            },
            {
              "Control": "LoyaltyTextInput",
              "Icon": "CelebrityIconTiny",
              "Label": "Celebrity Cruises",
              "Text": "{Value}",
              "BoundValue": "CelebrityLoyaltyNumber",
              "OnClickArgs": "cruiseline='Celebrity',firstName='{Value:PrimaryTravelerFirstName}',lastName='{Value:PrimaryTravelerLastName}',zipcode='{Value:ZipCode}'"
            },
            {
              "Control": "LoyaltyTextInput",
              "Icon": "DisneyIconTiny",
              "Label": "Disney Cruise Line",
              "Text": "{Value}",
              "BoundValue": "DisneyLoyaltyNumber",
              "OnClickArgs": "cruiseline='Disney',firstName='{Value:PrimaryTravelerFirstName}',lastName='{Value:PrimaryTravelerLastName}',zipcode='{Value:ZipCode}'"
            },
            {
              "Control": "LoyaltyTextInput",
              "Icon": "HollandAmericaIconTiny",
              "Label": "Holland America",
              "Text": "{Value}",
              "BoundValue": "HollandAmericaLoyaltyNumber",
              "OnClickArgs": "cruiseline='HollandAmerica',firstName='{Value:PrimaryTravelerFirstName}',lastName='{Value:PrimaryTravelerLastName}',zipcode='{Value:ZipCode}'"
            },
            {
              "Control": "LoyaltyTextInput",
              "Icon": "MSCIconTiny",
              "Label": "MSC Cruises",
              "Text": "{Value}",
              "BoundValue": "MSCLoyaltyNumber",
              "OnClickArgs": "cruiseline='MSC',firstName='{Value:PrimaryTravelerFirstName}',lastName='{Value:PrimaryTravelerLastName}',zipcode='{Value:ZipCode}'"
            },
            {
              "Control": "LoyaltyTextInput",
              "Icon": "NorwegianIconTiny",
              "Label": "Norwegian Cruise Line",
              "Text": "{Value}",
              "BoundValue": "NorwegianLoyaltyNumber",
              "OnClickArgs": "cruiseline='Norwegian',firstName='{Value:PrimaryTravelerFirstName}',lastName='{Value:PrimaryTravelerLastName}',zipcode='{Value:ZipCode}'"
            },
            {
              "Control": "LoyaltyTextInput",
              "Icon": "PrincessIconTiny",
              "Label": "Princess Cruises",
              "Text": "{Value}",
              "BoundValue": "PrincessLoyaltyNumber",
              "OnClickArgs": "cruiseline='Princess',firstName='{Value:PrimaryTravelerFirstName}',lastName='{Value:PrimaryTravelerLastName}',zipcode='{Value:ZipCode}'"
            },
            {
              "Control": "LoyaltyTextInput",
              "Icon": "RCCLIconTiny",
              "Label": "Royal Caribbean Cruise Line",
              "Text": "{Value}",
              "BoundValue": "RCCLLoyaltyNumber",
              "OnClickArgs": "cruiseline='RCCL',firstName='{Value:PrimaryTravelerFirstName}',lastName='{Value:PrimaryTravelerLastName}',zipcode='{Value:ZipCode}'"
            }
          ]
        }
      ]
    },
    {
      "Control": "Group",
      "ID": "grpPreferences",
      "Icon": "PreferencesIcon",
      "Label": "Preferences",
      "Text": "{Value:MinShipRating} Stars; Cabins: {Text:chkPreferredCabinTypes}",
      "Controls": [
        {
          "Control": "TextInput",
          "Validate": "\\d*",
          "Label": "Maximum price",
          "Text": "${'$'} {Value}",
          "BoundValue": "MaxPrice"
        },
        {
          "Control": "TextInput",
          "Validate": "\\d*",
          "Label": "Maximum price per day",
          "Text": "${'$'} {Value}",
          "BoundValue": "MaxPricePerDay"
        },
        {
          "Control": "Checkbox",
          "Label": "Kids sail free",
          "BoundValue": "KidsSailFree",
          "DefaultValue": "checked"
        },
        {
          "Control": "TextInput",
          "Validate": "[12345](\\.\\d)?",
          "Label": "Minimum ship rating",
          "Text": "{Value} stars",
          "BoundValue": "MinShipRating",
          "DefaultValue": "2"
        },
        {
          "Control": "CheckboxGroup",
          "ID": "chkShipSize",
          "Label": "Ship size",
          "Text": "{ListChildrenTrueAllNone:{Label}}",
          "DefaultValue": "checked",
          "Controls": [
            {
              "Control": "Checkbox",
              "Label": "Small",
              "BoundValue": "ShipSizeSmall",
              "DefaultValue": "checked"
            },
            {
              "Control": "Checkbox",
              "Label": "Medium",
              "BoundValue": "ShipSizeMedium",
              "DefaultValue": "checked"
            },
            {
              "Control": "Checkbox",
              "Label": "Large",
              "BoundValue": "ShipSizeLarge",
              "DefaultValue": "checked"
            }
          ]
        },
        {
          "Control": "CheckboxGroup",
          "ID": "chkPreferredCabinTypes",
          "Label": "Preferred cabin type",
          "Text": "{ListChildrenTrueAllNone:{Label}}",
          "DefaultValue": "indeterminate",
          "Controls": [
            {
              "Control": "Checkbox",
              "Label": "Inside",
              "BoundValue": "PreferInsideCabin",
              "DefaultValue": "unchecked"
            },
            {
              "Control": "Checkbox",
              "Label": "Ocean view",
              "BoundValue": "PreferOceanView",
              "DefaultValue": "unchecked"
            },
            {
              "Control": "Checkbox",
              "Label": "Interior balcony",
              "BoundValue": "PreferInteriorBalcony",
              "DefaultValue": "checked"
            },
            {
              "Control": "Checkbox",
              "Label": "Ocean view balcony",
              "BoundValue": "PreferBalcony",
              "DefaultValue": "checked"
            },
            {
              "Control": "Checkbox",
              "Label": "Suite",
              "BoundValue": "PreferSuite",
              "DefaultValue": "unchecked"
            },
            {
              "Control": "Checkbox",
              "Label": "Specialty suite",
              "BoundValue": "PreferSpecialtySuite",
              "DefaultValue": "unchecked"
            }
          ]
        },
        {
          "Control": "Checkbox",
          "Label": "Exclude non-refundable fares",
          "BoundValue": "ExcludeNonRefundable",
          "DefaultValue": "unchecked"
        }
      ]
    },
    {
      "Control": "CheckboxGroup",
      "ID": "chkActivities",
      "Label": "Desired Activities",
      "Text": "{ListChildrenTrueAllNone:{Label}}",
      "DefaultValue": "indeterminate",
      "Controls": [
        {
          "Control": "Checkbox",
          "Label": "Baby and tots",
          "BoundValue": "ActivityBaby",
          "DefaultValue": "unchecked"
        },
        {
          "Control": "Checkbox",
          "Label": "Beach and ocean",
          "BoundValue": "ActivityBeach",
          "DefaultValue": "checked"
        },
        {
          "Control": "Checkbox",
          "Label": "Luxury cruiseline",
          "BoundValue": "ActivityLuxury",
          "DefaultValue": "unchecked"
        },
        {
          "Control": "Checkbox",
          "Label": "Party and night life",
          "BoundValue": "ActivityParty",
          "DefaultValue": "unchecked"
        },
        {
          "Control": "Checkbox",
          "Label": "Pool and water activities",
          "BoundValue": "ActivityPool",
          "DefaultValue": "checked"
        },
        {
          "Control": "Checkbox",
          "Label": "Scenery and wildlife",
          "BoundValue": "ActivityScenery",
          "DefaultValue": "unchecked"
        },
        {
          "Control": "Checkbox",
          "Label": "Special shipboard activities",
          "BoundValue": "ActivityShipboard",
          "DefaultValue": "unchecked"
        },
        {
          "Control": "Checkbox",
          "Label": "Shopping",
          "BoundValue": "ActivityShopping",
          "DefaultValue": "unchecked"
        },
        {
          "Control": "Checkbox",
          "Label": "Spa and adult only",
          "BoundValue": "ActivitySpa",
          "DefaultValue": "unchecked"
        },
        {
          "Control": "Checkbox",
          "Label": "Teen and pre-teen activities",
          "BoundValue": "ActivityTeen",
          "DefaultValue": "unchecked"
        }
      ]
    },
    {
      "Control": "CheckboxGroup",
      "ID": "chkCruiseLines",
      "Label": "Cruise Lines",
      "Text": "{ListChildrenTrueAllNone:{Label}}",
      "DefaultValue": "checked",
      "Controls": [
        {
          "Control": "CheckboxGroup",
          "ID": "chkLineCarnival",
          "Label": "Carnival Cruise Line",
          "Text": "{ListChildrenTrueAllNone:{Label}}",
          "DefaultValue": "checked",
          "Controls": [
            {
              "Control": "CheckboxGroup",
              "ID": "chkClassCarnivalExcel",
              "Label": "Excel Class",
              "Text": "{ListChildrenTrueAllNone:{Label}}",
              "DefaultValue": "checked",
              "Controls": [
                {
                  "Control": "Checkbox",
                  "Label": "Carnival Celebration (2022)",
                  "BoundValue": "IncludeShipCarnivalCelebration",
                  "DefaultValue": "checked"
                },
                {
                  "Control": "Checkbox",
                  "Label": "Carnival Jubilee (2023)",
                  "BoundValue": "IncludeShipCarnivalJubilee",
                  "DefaultValue": "checked"
                }
              ]
            },
            {
              "Control": "CheckboxGroup",
              "ID": "chkClassCarnivalVista",
              "Label": "Vista/Venezia Class",
              "Text": "{ListChildrenTrueAllNone:{Label}}",
              "DefaultValue": "checked",
              "Controls": [
                {
                  "Control": "Checkbox",
                  "Label": "Carnival Firenze (2024)",
                  "BoundValue": "IncludeShipCarnivalFirenze",
                  "DefaultValue": "checked"
                },
                {
                  "Control": "Checkbox",
                  "Label": "Carnival Horizon (2018)",
                  "BoundValue": "IncludeShipCarnivalHorizon",
                  "DefaultValue": "checked"
                }
              ]
            }
          ]
        },
        {
          "Control": "CheckboxGroup",
          "ID": "chkLineCelebrity",
          "Label": "Celebrity Cruises",
          "Text": "{ListChildrenTrueAllNone:{Label}}",
          "DefaultValue": "checked",
          "Controls": [
            {
              "Control": "CheckboxGroup",
              "ID": "chkClassCelebrityEdge",
              "Label": "Edge Class",
              "Text": "{ListChildrenTrueAllNone:{Label}}",
              "DefaultValue": "checked",
              "Controls": [
                {
                  "Control": "Checkbox",
                  "Label": "Celebrity Apex (2020)",
                  "BoundValue": "IncludeShipCelebrityApex",
                  "DefaultValue": "checked"
                },
                {
                  "Control": "Checkbox",
                  "Label": "Celebrity Beyond (2022)",
                  "BoundValue": "IncludeShipCelebrityBeyond",
                  "DefaultValue": "checked"
                }
              ]
            },
            {
              "Control": "CheckboxGroup",
              "ID": "chkClassCelebritySolstice",
              "Label": "Solstice Class",
              "Text": "{ListChildrenTrueAllNone:{Label}}",
              "DefaultValue": "checked",
              "Controls": [
                {
                  "Control": "Checkbox",
                  "Label": "Celebrity Eclipse (2010)",
                  "BoundValue": "IncludeShipCelebrityEclipse",
                  "DefaultValue": "checked"
                },
                {
                  "Control": "Checkbox",
                  "Label": "Celebrity Equinox (2009)",
                  "BoundValue": "IncludeShipCelebrityEquinox",
                  "DefaultValue": "checked"
                }
              ]
            }
          ]
        }
      ]
    }
  ]
}
"""