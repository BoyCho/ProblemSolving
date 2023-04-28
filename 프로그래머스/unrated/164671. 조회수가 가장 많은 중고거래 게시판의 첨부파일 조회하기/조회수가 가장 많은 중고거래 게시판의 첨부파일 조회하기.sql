-- 코드를 입력하세요
SELECT concat('/home/grep/src/', F.BOARD_ID, '/', F.FILE_ID, F.FILE_NAME, FILE_EXT) FILE_PATH
FROM USED_GOODS_BOARD B
    LEFT JOIN USED_GOODS_FILE F
    ON B.BOARD_ID = F.BOARD_ID
WHERE B.VIEWS IN (
    SELECT max(USED_GOODS_BOARD.VIEWS)
    FROM USED_GOODS_BOARD)
ORDER BY F.FILE_ID DESC
