$ErrorActionPreference = "Stop"

$AEM_HOST    = "https://author-p139816-e1765605.adobeaemcloud.com/"
$ORG_ID        = "E1891E586621321E0A495C63@AdobeOrg"
$CLIENT_ID     = "5a62e035a17b4657a2edd6871653cd4a"
$CLIENT_SECRET = "p8e-erMx7icl59hiM5quREkY0PvKmNQ2Ppmk"
$SCOPES = "openid,AdobeID,read_organizations,additional_info.projectedProductContext,read_pc.dma_aem_ams"
$LOCAL_BACKUP_PATH = "C:\backups\backup.zip"

$body = @{
    client_id     = $CLIENT_ID
    client_secret = $CLIENT_SECRET
    grant_type    = "client_credentials"
    scope         = $SCOPES
}

$tokenResponse = Invoke-RestMethod -Method Post -Uri "https://ims-na1.adobelogin.com/ims/token/v3" -Body $body
$ACCESS_TOKEN = $tokenResponse.access_token

Invoke-RestMethod -Uri "$AEM_HOST/crx/packmgr/service/.json/etc/packages/backup/backup.zip?cmd=create" `
    -Method Post `
    -Headers @{Authorization = "Bearer $ACCESS_TOKEN"} `
    -Body @{
        packageName = "backup"
        groupName   = "backup"
        path        = "/content/newsportal"
    }

Invoke-WebRequest -Uri "$AEM_HOST/etc/packages/backup/backup.zip" `
    -Headers @{Authorization = "Bearer $ACCESS_TOKEN"} `
    -OutFile $LOCAL_BACKUP_PATH
