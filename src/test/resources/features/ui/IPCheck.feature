@CheckIPs
Feature: Check to see if IPs load

  Scenario Outline: Check CASMR IP Addresses
    Given Open <IP Address>
    Then the page should load correctly for "<Site>"
    Examples:
      | Site                       | IP Address                    |
      | Baton Rouge                | https://100.120.255.148:8010/ |
      | Connecticut                | https://100.120.255.153:8010/ |
      | Hampton Roads              | https://100.120.255.163:8010/ |
      | Kansas/Arkansas            | https://100.120.255.178:8010/ |
      | Macon                      | https://100.120.255.138:8010/ |
      | New Orleans                | https://100.120.255.183:8010/ |
      | Omaha/Sun Valley           | https://100.120.255.143:8010/ |
      | Orange County/Palos Verdes | https://100.120.255.158:8010/ |
      | Rhode Island               | https://100.120.255.168:8010/ |
      | Roanoke                    | https://100.120.255.133:8010/ |
      | Tulsa                      | https://100.120.255.173:8010/ |
