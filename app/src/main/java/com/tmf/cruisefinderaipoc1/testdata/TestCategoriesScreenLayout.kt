package com.tmf.cruisefinderaipoc1.testdata

const val testCategoriesScreenLayout = """
    ,
{
  "Control": "Repeater",
  "ID": "rptCategories",
  "BoundValue": "Categories",
  "Controls": [
    {
      "Control": "Group",
      "ID": "grpCategories",
      "Icon": "{Value:Icon}",
      "Label": "{Value:TotalPrice} {Value:Title}",
      "Controls": [
        {
          "Control": "Button",
          "ID": "btnCategory",
          "Label": "SELECT CATEGORY",
          "OnClick": "SelectCategory",
          "OnClickArgs": "categoryId={Value:ID}"
        },
        {
          "Control": "Group",
          "ID": "grpPrice",
          "Label": "Price",
          "Controls": [
            {
              "Control": "Repeater",
              "ID": "rptPriceByGuest",
              "BoundValue": "PriceByGuest",
              "Controls": [
                {
                  "Control": "Text",
                  "ID": "txtGuestNPrice",
                  "Label": "Guest #{Value:GuestNumber}",
                  "Text": "{Value:Price}",
                  "AlignText": "Right"
                }
              ]
            },
            {
              "Control": "Text",
              "ID": "txtTaxAndFees",
              "Label": "Tax & Fees",
              "Text": "{Value:TaxAndFees}",
              "AlignText": "Right"
            }
          ]
        }
      ]
    }
  ]
}
"""
