SELECT 
    score,
    -- DENSE_RANK() is a window function that assigns ranks based on the specified ordering,
    -- and unlike RANK(), it does NOT leave gaps in the ranking sequence when there are ties.
    -- Example: RANK() gives 1,1,3,4  ->  DENSE_RANK() gives 1,1,2,3
    DENSE_RANK() OVER (
        -- ORDER BY score DESC tells the window function to rank scores 
        -- from highest to lowest, so the top score always gets rank 1
        ORDER BY score DESC
    ) AS `rank`  -- wrapped in backticks since RANK is a reserved MySQL keyword
FROM Scores
-- final ORDER BY ensures the output rows themselves are sorted by score descending,
-- as required by the problem (this is separate from the ranking logic above)
ORDER BY score DESC;