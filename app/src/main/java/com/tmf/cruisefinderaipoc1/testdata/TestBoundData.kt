package com.tmf.cruisefinderaipoc1.testdata

const val testBoundData = """
{
  "Data": [
    {
      "ID": "PrimaryTravelerFirstName",
      "Value": "Michael"
    },
    {
      "ID": "PrimaryTravelerLastName",
      "Value": "Mayfield"
    },
    {
      "ID": "OldestTravelerBirthDate",
      "Value": "08/18/1953"
    },
    {
      "ID": "NumberOfAdults",
      "Value": "2"
    },
    {
      "ID": "NumberOfChildren",
      "Value": "1"
    },
    {
      "ID": "PreferInsideCabin",
      "Value": "True"
    },
    {
      "ID": "MinShipRating",
      "Value": "4.0"
    },
    {
      "ID": "Categories",
      "Collection": [
        {
          "Data": [
            {
              "ID": "ID",
              "Value": "0"
            },
            {
              "ID": "Title",
              "Value": "2A: Inside with virtual balcony"
            },
            {
              "ID": "Icon",
              "Value": "CarnivalCategory2A"
            },
            {
              "ID": "TotalPrice",
              "Value": "$ 1,500.00"
            },
            {
              "ID": "TaxAndFees",
              "Value": "$ 500.00"
            },
            {
              "ID": "PriceByGuest",
              "Collection": [
                {
                  "Data": [
                    {
                      "ID": "GuestNumber",
                      "Value": "1"
                    },
                    {
                      "ID": "Price",
                      "Value": "$ 200.00"
                    }
                  ]
                },
                {
                  "Data": [
                    {
                      "ID": "GuestNumber",
                      "Value": "2"
                    },
                    {
                      "ID": "Price",
                      "Value": "$ 200.00"
                    }
                  ]
                }
              ]
            }
          ]
        },
        {
          "Data": [
            {
              "ID": "ID",
              "Value": "1"
            },
            {
              "ID": "Title",
              "Value": "4A: Ocean view balcony"
            },
            {
              "ID": "Icon",
              "Value": "CarnivalCategory4A"
            },
            {
              "ID": "TotalPrice",
              "Value": "$ 2,500.00"
            },
            {
              "ID": "TaxAndFees",
              "Value": "$ 500.00"
            },
            {
              "ID": "PriceByGuest",
              "Collection": [
                {
                  "Data": [
                    {
                      "ID": "GuestNumber",
                      "Value": "1"
                    },
                    {
                      "ID": "Price",
                      "Value": "$ 1,000.00"
                    }
                  ]
                },
                {
                  "Data": [
                    {
                      "ID": "GuestNumber",
                      "Value": "2"
                    },
                    {
                      "ID": "Price",
                      "Value": "$ 1,000.00"
                    }
                  ]
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