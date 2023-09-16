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
      "ID": "grpPreferences",
      "Icon": "PreferencesIcon",
      "Label": "Preferences",
      "Text": "{Value:MinShipRating} Stars; Cabins: {Text:ckgPreferredCabinTypes}",
      "Controls": [
        {
          "Control": "CheckboxGroup",
          "ID": "ckgPreferredCabinTypes",
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
          "Control": "CheckboxGroup",
          "ID": "ckgShipSize",
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
          "Control": "Dropdown",
          "Label": "Minimum ship rating",
          "Text": "{Value} stars",
          "BoundValue": "MinShipRating",
          "Choices": "1|1.5|2|2.5|3|3.5|4|4.5",
          "DefaultValue": "3.5"
        },
        {
          "Control": "TextInput",
          "Validate": "\\d*",
          "Label": "Maximum price per person",
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
          "DefaultValue": "unchecked"
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
      "Control": "Group",
      "ID": "grpDeparturePorts",
      "Label": "Departure ports",
      "Text": "{ListChildrenTrueAllNone:{Label}}",
      "DefaultValue": "checked",
      "Controls": [
        {
          "Control": "CheckboxGroup",
          "ID": "ckgDepartureEastern",
          "Label": "Eastern USA",
          "Text": "{ListChildrenTrueAllNone:{Label}}",
          "DefaultValue": "checked",
          "Controls": [
            {
              "Control": "Checkbox",
              "Label": "Baltimore, MD",
              "BoundValue": "DeparturePortBaltimore",
              "DefaultValue": "checked"
            },
            {
              "Control": "Checkbox",
              "Label": "Bayonne, NJ",
              "BoundValue": "DeparturePortBayonne",
              "DefaultValue": "checked"
            },
            {
              "Control": "Checkbox",
              "Label": "Boston, MA",
              "BoundValue": "DeparturePortBoston",
              "DefaultValue": "checked"
            },
            {
              "Control": "Checkbox",
              "Label": "Brooklyn, NY",
              "BoundValue": "DeparturePortBrooklyn",
              "DefaultValue": "checked"
            },
            {
              "Control": "Checkbox",
              "Label": "New York, NY",
              "BoundValue": "DeparturePortNewYork",
              "DefaultValue": "checked"
            },
            {
              "Control": "Checkbox",
              "Label": "Norfolk, VA",
              "BoundValue": "DeparturePortNorfolk",
              "DefaultValue": "checked"
            }
          ]
        },
        {
          "Control": "CheckboxGroup",
          "ID": "ckgDepartureFlorida",
          "Label": "Florida",
          "Text": "{ChildrenCheckedAllSomeNone}",
          "DefaultValue": "checked",
          "Controls": [
            {
              "Control": "Checkbox",
              "Label": "Ft. Lauderdale",
              "BoundValue": "DeparturePortFtLauderdale",
              "DefaultValue": "checked"
            },
            {
              "Control": "Checkbox",
              "Label": "Jacksonville",
              "BoundValue": "DeparturePortJacksonville",
              "DefaultValue": "checked"
            },
            {
              "Control": "Checkbox",
              "Label": "Miami",
              "BoundValue": "DeparturePortMiami",
              "DefaultValue": "checked"
            },
            {
              "Control": "Checkbox",
              "Label": "Orlando/Port Canaveral",
              "BoundValue": "DeparturePortOrlando",
              "DefaultValue": "checked"
            },
            {
              "Control": "Checkbox",
              "Label": "Tampa",
              "BoundValue": "DeparturePortTampa",
              "DefaultValue": "checked"
            }
          ]
        },
        {
          "Control": "CheckboxGroup",
          "ID": "ckgDepartureSouthernUSA",
          "Label": "Southern USA",
          "Text": "{ChildrenCheckedAllSomeNone}",
          "DefaultValue": "checked",
          "Controls": [
            {
              "Control": "Checkbox",
              "Label": "Charleston, SC",
              "BoundValue": "DeparturePortCharleston",
              "DefaultValue": "checked"
            },
            {
              "Control": "Checkbox",
              "Label": "Galveston, TX",
              "BoundValue": "DeparturePortGalveston",
              "DefaultValue": "checked"
            },
            {
              "Control": "Checkbox",
              "Label": "Houston, TX",
              "BoundValue": "DeparturePortHouston",
              "DefaultValue": "checked"
            },
            {
              "Control": "Checkbox",
              "Label": "Mobile, AL",
              "BoundValue": "DeparturePortMobile",
              "DefaultValue": "checked"
            },
            {
              "Control": "Checkbox",
              "Label": "New Orleans, LA",
              "BoundValue": "DeparturePortNewOrleans",
              "DefaultValue": "checked"
            }
          ]
        },
        {
          "Control": "CheckboxGroup",
          "ID": "ckgDeparturePacific",
          "Label": "Western USA",
          "Text": "{ChildrenCheckedAllSomeNone}",
          "DefaultValue": "checked",
          "Controls": [
            {
              "Control": "CheckboxGroup",
              "ID": "ckgDepartureAlaska",
              "Label": "Alaska",
              "Text": "{ChildrenCheckedAllSomeNone}",
              "DefaultValue": "checked",
              "Controls": [
                {
                  "Control": "Checkbox",
                  "Label": "Anchorage/Whittier",
                  "BoundValue": "DeparturePortAnchorage",
                  "DefaultValue": "checked"
                },
                {
                  "Control": "Checkbox",
                  "Label": "Seward",
                  "BoundValue": "DeparturePortSeward",
                  "DefaultValue": "checked"
                }
              ]
            },
            {
              "Control": "CheckboxGroup",
              "ID": "ckgDepartureCalifornia",
              "Label": "California",
              "Text": "{ChildrenCheckedAllSomeNone}",
              "DefaultValue": "checked",
              "Controls": [
                {
                  "Control": "Checkbox",
                  "Label": "Long Beach/LA",
                  "BoundValue": "DeparturePortLongBeach",
                  "DefaultValue": "checked"
                },
                {
                  "Control": "Checkbox",
                  "Label": "San Diego",
                  "BoundValue": "DeparturePortSanDiego",
                  "DefaultValue": "checked"
                },
                {
                  "Control": "Checkbox",
                  "Label": "San Francisco",
                  "BoundValue": "DeparturePortSanFrancisco",
                  "DefaultValue": "checked"
                },
                {
                  "Control": "Checkbox",
                  "Label": "San Pedro/LA",
                  "BoundValue": "DeparturePortSanPedro",
                  "DefaultValue": "checked"
                }
              ]
            },
            {
              "Control": "Checkbox",
              "Label": "Hawaii - Honolulu/Oahu",
              "BoundValue": "DeparturePortHawaii",
              "DefaultValue": "checked"
            },
            {
              "Control": "Checkbox",
              "Label": "Seattle, WA",
              "BoundValue": "DeparturePortSeattle",
              "DefaultValue": "checked"
            }
          ]
        },
        {
          "Control": "CheckboxGroup",
          "ID": "ckgDepartureCanada",
          "Label": "Canada",
          "Text": "{ListChildrenTrueAllNone:{Label}}",
          "DefaultValue": "checked",
          "Controls": [
            {
              "Control": "Checkbox",
              "Label": "Montreal, QC",
              "BoundValue": "DeparturePortMontreal",
              "DefaultValue": "checked"
            },
            {
              "Control": "Checkbox",
              "Label": "Quebec City, QC",
              "BoundValue": "DeparturePortQuebec",
              "DefaultValue": "checked"
            },
            {
              "Control": "Checkbox",
              "Label": "Vancouver, BC",
              "BoundValue": "DeparturePortVancouver",
              "DefaultValue": "checked"
            }
          ]
        },
        {
          "Control": "CheckboxGroup",
          "ID": "ckgDepartureEngland",
          "Label": "England",
          "Text": "{ListChildrenTrueAllNone:{Label}}",
          "DefaultValue": "checked",
          "Controls": [
            {
              "Control": "Checkbox",
              "Label": "Dover",
              "BoundValue": "DeparturePortDover",
              "DefaultValue": "checked"
            },
            {
              "Control": "Checkbox",
              "Label": "London",
              "BoundValue": "DeparturePortLondon",
              "DefaultValue": "checked"
            },
            {
              "Control": "Checkbox",
              "Label": "Southhampton",
              "BoundValue": "DeparturePortSouthhampton",
              "DefaultValue": "checked"
            }
          ]
        },
        {
          "Control": "CheckboxGroup",
          "ID": "ckgDepartureGermany",
          "Label": "Germany",
          "Text": "{ListChildrenTrueAllNone:{Label}}",
          "DefaultValue": "checked",
          "Controls": [
            {
              "Control": "Checkbox",
              "Label": "Berlin/Warnemunde",
              "BoundValue": "DeparturePortBerlin",
              "DefaultValue": "checked"
            },
            {
              "Control": "Checkbox",
              "Label": "Munich",
              "BoundValue": "DeparturePortMunich",
              "DefaultValue": "checked"
            },
            {
              "Control": "Checkbox",
              "Label": "Nuremberg",
              "BoundValue": "DeparturePortNuremberg",
              "DefaultValue": "checked"
            }
          ]
        },
        {
          "Control": "CheckboxGroup",
          "ID": "ckgDepartureMediteranean",
          "Label": "Mediteranean",
          "Text": "{ListChildrenTrueAllNone:{Label}}",
          "DefaultValue": "checked",
          "Controls": [
            {
              "Control": "Checkbox",
              "Label": "Athens/Piraeus Greece",
              "BoundValue": "DeparturePortAthens",
              "DefaultValue": "checked"
            },
            {
              "Control": "Checkbox",
              "Label": "Rome/Civitavechhia Italy",
              "BoundValue": "DeparturePortRome",
              "DefaultValue": "checked"
            },
            {
              "Control": "Checkbox",
              "Label": "Venice, Italy",
              "BoundValue": "DeparturePortVenice",
              "DefaultValue": "checked"
            }
          ]
        }
      ]
    },
    {
      "Control": "Group",
      "ID": "grpDestinations",
      "Label": "Destinations",
      "Text": "{ListChildrenTrueAllNone:{Label}}",
      "DefaultValue": "checked",
      "Controls": [
        {
          "Control": "CheckboxGroup",
          "ID": "ckgCaribbean",
          "Label": "Western Caribbean",
          "Text": "{ChildrenCheckedAllSomeNone}",
          "DefaultValue": "checked",
          "Controls": [
            {
              "Control": "Checkbox",
              "Label": "Cozumel, MX",
              "BoundValue": "DestinationCozumel",
              "DefaultValue": "checked"
            },
            {
              "Control": "Checkbox",
              "Label": "Roatan",
              "BoundValue": "DestinationRoatan",
              "DefaultValue": "checked"
            }
          ]
        },
        {
          "Control": "CheckboxGroup",
          "ID": "ckgDestinationEasternCaribbean",
          "Label": "Eastern Caribbean",
          "Text": "{ListChildrenTrueAllNone:{Label}}",
          "DefaultValue": "checked",
          "Controls": [
            {
              "Control": "Checkbox",
              "Label": "St. Marten",
              "BoundValue": "DestinationStMarten",
              "DefaultValue": "checked"
            },
            {
              "Control": "Checkbox",
              "Label": "St. Thomas",
              "BoundValue": "DestinationStThomas",
              "DefaultValue": "checked"
            },
            {
              "Control": "Checkbox",
              "Label": "Bonaire",
              "BoundValue": "DestinationBonaire",
              "DefaultValue": "checked"
            }
          ]
        }
      ]
    },
    {
      "Control": "Group",
      "ID": "grpDuration",
      "Label": "Duration",
      "Text": "{ListChildrenTrueAllNone:{Label}}",
      "DefaultValue": "indeterminate",
      "Controls": [
        {
          "Control": "Checkbox",
          "Label": "Short break (1-2 nights)",
          "BoundValue": "DurationShort",
          "DefaultValue": "unchecked"
        },
        {
          "Control": "Checkbox",
          "Label": "Quick getaway (2-5 nights)",
          "BoundValue": "DurationQuick",
          "DefaultValue": "unchecked"
        },
        {
          "Control": "Checkbox",
          "Label": "Week (6-8 nights)",
          "BoundValue": "DurationWeek",
          "DefaultValue": "checked"
        },
        {
          "Control": "Checkbox",
          "Label": "Extended (9+ nights)",
          "BoundValue": "DurationExtended",
          "DefaultValue": "unchecked"
        }
      ]
    },
    {
      "Control": "Group",
      "ID": "grpDepartureDate",
      "Icon": "DepartureDateIcon",
      "Label": "Departure Date",
      "Text": "{Value:DepartureStartDate} thru {Value:DepartureEndDate}",
      "Controls": [
        {
          "Control": "Date",
          "Label": "Starting date",
          "BoundValue": "DepartureStartDate"
        },
        {
          "Control": "Date",
          "Label": "Ending date",
          "BoundValue": "DepartureEndDate",
          "DefaultValue": "12/31/2025"
        },
        {
          "Control": "CheckboxGroup",
          "ID": "ckgExcludeHolidays",
          "Label": "Exclude holidays",
          "Text": "{ListChildrenTrueAllNone:{Label}}",
          "DefaultValue": "unchecked",
          "Controls": [
            {
              "Control": "Checkbox",
              "Label": "Christian",
              "BoundValue": "ExcludeHolidayChristian",
              "DefaultValue": "unchecked"
            },
            {
              "Control": "Checkbox",
              "Label": "Jewish",
              "BoundValue": "ExcludeHolidayJewish",
              "DefaultValue": "unchecked"
            },
            {
              "Control": "Checkbox",
              "Label": "Muslim",
              "BoundValue": "ExcludeHolidayMuslim",
              "DefaultValue": "unchecked"
            },
            {
              "Control": "Checkbox",
              "Label": "US National",
              "BoundValue": "ExcludeHolidayUS",
              "DefaultValue": "unchecked"
            }
          ]
        }
      ]
    },
    {
      "Control": "Group",
      "ID": "grpCruiseLines",
      "Label": "Cruise Lines and Ships",
      "Text": "{ChildrenCheckedAllSomeNone}",
      "DefaultValue": "checked",
      "Controls": [
        {
          "Control": "CheckboxGroup",
          "ID": "ckgLineCarnival",
          "Label": "Carnival Cruise Line",
          "Text": "{ChildrenCheckedAllSomeNone}",
          "DefaultValue": "checked",
          "Controls": [
            {
              "Control": "CheckboxGroup",
              "ID": "ckgClassCarnivalExcel",
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
              "ID": "ckgClassCarnivalVista",
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
                },
                {
                  "Control": "Checkbox",
                  "Label": "Carnival Panorama (2019)",
                  "BoundValue": "IncludeShipCarnivalPanorama",
                  "DefaultValue": "checked"
                },
                {
                  "Control": "Checkbox",
                  "Label": "Carnival Venezia (2023)",
                  "BoundValue": "IncludeShipCarnivalVenezia",
                  "DefaultValue": "checked"
                },
                {
                  "Control": "Checkbox",
                  "Label": "Carnival Vista (2016)",
                  "BoundValue": "IncludeShipCarnivalVista",
                  "DefaultValue": "checked"
                }
              ]
            }
          ]
        },
        {
          "Control": "CheckboxGroup",
          "ID": "ckgLineCelebrity",
          "Label": "Celebrity Cruises",
          "Text": "{ChildrenCheckedAllSomeNone}",
          "DefaultValue": "checked",
          "Controls": [
            {
              "Control": "CheckboxGroup",
              "ID": "ckgClassCelebrityEdge",
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
              "ID": "ckgClassCelebritySolstice",
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
    },
    {
      "Control": "Group",
      "ID": "grpActivities",
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
              "Label": "Legal first name",
              "Text": "{Value}",
              "Hint": "Enter first name",
              "BoundValue": "PrimaryTravelerFirstName",
              "Validate": "^(?!\\s*${'$'}).+"
            },
            {
              "Control": "TextInput",
              "Label": "Legal last name",
              "Text": "{Value}",
              "Hint": "Enter last name",
              "BoundValue": "PrimaryTravelerLastName",
              "Validate": "^(?!\\s*${'$'}).+"
            },
            {
              "Control": "TextInput",
              "Label": "Zip code",
              "Text": "{Value}",
              "Validate": "\\d{5}",
              "Hint": "99999",
              "BoundValue": "PrimaryZipCode",
              "DefaultValue": "99999"
            },
            {
              "Control": "Date",
              "Label": "Birth date",
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
          "Text": "{ListChildrenNonEmptyNone:{Label}}",
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
              "DefaultValue": "117624231",
              "OnClickArgs": "cruiseline='RCCL',firstName='{Value:PrimaryTravelerFirstName}',lastName='{Value:PrimaryTravelerLastName}',zipcode='{Value:ZipCode}'"
            }
          ]
        }
      ]
    }
  ]
}
"""