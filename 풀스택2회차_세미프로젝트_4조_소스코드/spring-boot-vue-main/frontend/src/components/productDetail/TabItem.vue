<template>
    <button
        @click="$emit('input', id)"
        :class="[active, 'tab']"
    >
        {{ label }}
    </button>
</template>

<script>
export default {
    props: {
        id: Number,
        label: String,
        value: Number,
    },
    computed: {
        active() {
            return this.value === this.id ? "active" : false;
        },
    },
};
</script>

<style scoped>
.tab {
    border-radius: 2px 2px 0 0;
    background: rgba(0, 153, 255, 0.5);
    color: white;
    line-height: 24px;
    width: 140px;
}

.tab:hover {
    background: rgb(0, 153, 255);
    color: white;
}

.active {
    background: rgb(0, 153, 255);
    color: white;
}
</style>
