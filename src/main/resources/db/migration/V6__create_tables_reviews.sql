CREATE TABLE IF NOT EXISTS reviews(
    id BIGSERIAL PRIMARY KEY,
    rating INT NOT NULL CHECK (rating >= 1 AND rating <= 5),
    comment TEXT,
    schedule_id BIGINT NOT NULL,
    athlete_id BIGINT NOT NULL,
    FOREIGN KEY (schedule_id) REFERENCES schedules(id) ON DELETE CASCADE,
    FOREIGN KEY (athlete_id) REFERENCES athletes(id) ON DELETE CASCADE,
    created_at TIMESTAMP DEFAULT now()
);